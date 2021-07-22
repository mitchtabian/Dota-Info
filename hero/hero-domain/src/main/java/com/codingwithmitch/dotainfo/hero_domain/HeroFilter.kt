package com.codingwithmitch.dotainfo.hero_domain

import com.codingwithmitch.core.domain.FilterOrder

sealed class HeroFilter(val uiValue: String,) {

    data class Hero(
        val order: FilterOrder = FilterOrder.Descending
    ): HeroFilter("Hero")

    data class ProWins(
        val order: FilterOrder = FilterOrder.Descending
    ): HeroFilter("Pro win-rate")

    data class PrimaryAttribute(
        val attribute: HeroAttribute = HeroAttribute.Strength
    ): HeroFilter("Primary Attribute")
}





