package com.codingwithmitch.dotainfo.hero_interactors.interactors

import com.codingwithmitch.core.domain.FilterOrder
import com.codingwithmitch.dotainfo.hero_domain.HeroAttribute
import com.codingwithmitch.dotainfo.hero_domain.HeroFilter
import com.codingwithmitch.dotainfo.hero_interactors.FilterHeros
import com.codingwithmitch.dotainfo.hero_interactors.datasource.network.data.HeroDataValid
import com.codingwithmitch.dotainfo.hero_interactors.datasource.network.serializeHeroData
import org.junit.Test
import kotlin.math.round

/**
 * 1. Success (Search for specific hero by 'localizedName' param)
 * 2. Success (Order by 'localizedName' param DESC)
 * 3. Success (Order by 'localizedName' param ASC)
 * 4. Success (Order by 'proWins' % ASC)
 * 5. Success (Order by 'proWins' % DESC)
 * 6. Success (Filter by 'HeroAttribute' "Strength")
 * 7. Success (Filter by 'HeroAttribute' "Agility")
 * 8. Success (Filter by 'HeroAttribute' "Intelligence")
 */
class FilterHerosTest {

    // System in test
    private lateinit var filterHeros: FilterHeros

    // Data
    private val heroList = serializeHeroData(HeroDataValid.data)

    @Test
    fun searchHeroByName(){
        filterHeros = FilterHeros()

        // Execute use-case
        val emissions = filterHeros.execute(
            current = heroList,
            heroName = "Slark",
            heroFilter = HeroFilter.Hero(),
            attributeFilter = HeroAttribute.Unknown,
        )

        // confirm it returns a single hero
        assert(emissions[0].localizedName == "Slark")
    }

    @Test
    fun orderByNameDesc(){
        filterHeros = FilterHeros()

        // Execute use-case
        val emissions = filterHeros.execute(
            current = heroList,
            heroName = "",
            heroFilter = HeroFilter.Hero(order = FilterOrder.Descending),
            attributeFilter = HeroAttribute.Unknown,
        )

        // confirm they are ordered Z-A
        for(index in 1..emissions.size - 1){
            assert(emissions[index-1].localizedName.toCharArray()[0] >= emissions[index].localizedName.toCharArray()[0])
        }
    }

    @Test
    fun orderByNameAsc(){
        filterHeros = FilterHeros()

        // Execute use-case
        val emissions = filterHeros.execute(
            current = heroList,
            heroName = "",
            heroFilter = HeroFilter.Hero(order = FilterOrder.Ascending),
            attributeFilter = HeroAttribute.Unknown,
        )

        // confirm they are ordered A-Z
        for(index in 1..emissions.size - 1){
            assert(emissions[index-1].localizedName.toCharArray()[0] <= emissions[index].localizedName.toCharArray()[0])
        }
    }

    @Test
    fun orderByProWinsDesc(){
        filterHeros = FilterHeros()

        // Execute use-case
        val emissions = filterHeros.execute(
            current = heroList,
            heroName = "",
            heroFilter = HeroFilter.ProWins(order = FilterOrder.Descending),
            attributeFilter = HeroAttribute.Unknown,
        )

        // confirm they are ordered highest to lowest
        for(index in 1..emissions.size - 1){
            val prevWinPercentage = round(emissions[index-1].proWins.toDouble() / emissions[index-1].proPick.toDouble() * 100).toInt()
            val currWinPercentage = round(emissions[index].proWins.toDouble() / emissions[index].proPick.toDouble() * 100).toInt()

            assert(prevWinPercentage >= currWinPercentage)
        }
    }

    @Test
    fun orderByProWinsAsc(){
        filterHeros = FilterHeros()

        // Execute use-case
        val emissions = filterHeros.execute(
            current = heroList,
            heroName = "",
            heroFilter = HeroFilter.ProWins(order = FilterOrder.Ascending),
            attributeFilter = HeroAttribute.Unknown,
        )

        // confirm they are ordered lowest to highest
        for(index in 1..emissions.size - 1){
            val prevWinPercentage = round(emissions[index-1].proWins.toDouble() / emissions[index-1].proPick.toDouble() * 100).toInt()
            val currWinPercentage = round(emissions[index].proWins.toDouble() / emissions[index].proPick.toDouble() * 100).toInt()

            assert(prevWinPercentage <= currWinPercentage)
        }
    }

    @Test
    fun filterByStrength(){
        filterHeros = FilterHeros()

        // Execute use-case
        val emissions = filterHeros.execute(
            current = heroList,
            heroName = "",
            heroFilter = HeroFilter.Hero(),
            attributeFilter = HeroAttribute.Strength,
        )

        for(hero in emissions){
            assert(hero.primaryAttribute is HeroAttribute.Strength)
        }
    }

    @Test
    fun filterByAgility(){
        filterHeros = FilterHeros()

        // Execute use-case
        val emissions = filterHeros.execute(
            current = heroList,
            heroName = "",
            heroFilter = HeroFilter.Hero(),
            attributeFilter = HeroAttribute.Agility,
        )

        for(hero in emissions){
            assert(hero.primaryAttribute is HeroAttribute.Agility)
        }
    }

    @Test
    fun filterByIntelligence(){
        filterHeros = FilterHeros()

        // Execute use-case
        val emissions = filterHeros.execute(
            current = heroList,
            heroName = "",
            heroFilter = HeroFilter.Hero(),
            attributeFilter = HeroAttribute.Intelligence,
        )

        for(hero in emissions){
            assert(hero.primaryAttribute is HeroAttribute.Intelligence)
        }
    }
}
















