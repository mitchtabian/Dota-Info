package com.codingwithmitch.ui_herolist.util

import com.codingwithmitch.core.domain.SqlFilterOrder
import com.codingwithmitch.dotainfo.hero_domain.HeroAttribute

sealed class HeroFilter(val uiValue: String,) {

    data class Hero(
        val order: SqlFilterOrder = SqlFilterOrder.Descending
    ): HeroFilter("Hero")

    data class ProWins(
        val order: SqlFilterOrder = SqlFilterOrder.Descending
    ): HeroFilter("Pro win-rate")

    data class PrimaryAttribute(
        val attribute: HeroAttribute = HeroAttribute.Strength
    ): HeroFilter("Primary Attribute")
}





