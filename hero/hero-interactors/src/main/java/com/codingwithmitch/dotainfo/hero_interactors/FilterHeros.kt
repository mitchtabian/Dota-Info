package com.codingwithmitch.dotainfo.hero_interactors

import com.codingwithmitch.core.domain.FilterOrder
import com.codingwithmitch.dotainfo.hero_domain.Hero
import com.codingwithmitch.dotainfo.hero_domain.HeroAttribute
import com.codingwithmitch.dotainfo.hero_domain.HeroFilter
import kotlin.math.round

class FilterHeros {

    fun execute(
        current: List<Hero>,
        heroName: String,
        heroFilter: HeroFilter,
        attributeFilter: HeroAttribute,
    ): List<Hero> {
        var filteredList: MutableList<Hero> = current.filter {
            it.localizedName.lowercase().contains(heroName.lowercase())
        }.toMutableList()

        when(heroFilter){
            is HeroFilter.Hero -> {
                when(heroFilter.order){
                    is FilterOrder.Descending -> {
                        filteredList.sortByDescending { it.localizedName  }
                    }
                    is FilterOrder.Ascending -> {
                        filteredList.sortBy { it.localizedName  }
                    }
                }
            }
            is HeroFilter.ProWins -> {
                when(heroFilter.order){
                    is FilterOrder.Descending -> {
                        filteredList.sortByDescending {
                            if(it.proPick <= 0){ // can't divide by 0
                                0
                            }
                            else{
                                val winRate: Int = round(it.proWins.toDouble() / it.proPick.toDouble() * 100).toInt()
                                winRate
                            }
                        }
                    }
                    is FilterOrder.Ascending -> {
                        filteredList.sortBy {
                            if(it.proPick <= 0){ // can't divide by 0
                                0
                            }
                            else{
                                val winRate: Int = round(it.proWins.toDouble() / it.proPick.toDouble() * 100).toInt()
                                winRate
                            }
                        }
                    }
                }
            }
        }

        when(attributeFilter){
            is HeroAttribute.Strength -> {
                filteredList = filteredList.filter { it.primaryAttribute is HeroAttribute.Strength }.toMutableList()
            }
            is HeroAttribute.Agility -> {
                filteredList = filteredList.filter { it.primaryAttribute is HeroAttribute.Agility }.toMutableList()
            }
            is HeroAttribute.Intelligence -> {
                filteredList = filteredList.filter { it.primaryAttribute is HeroAttribute.Intelligence }.toMutableList()
            }
            is HeroAttribute.Unknown -> {
                // do not filter
            }
        }

        return filteredList
    }
}