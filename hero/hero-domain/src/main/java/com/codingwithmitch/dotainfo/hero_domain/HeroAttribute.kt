package com.codingwithmitch.dotainfo.hero_domain

sealed class HeroAttribute{
    data class Agility(
        val value: String = "Agility"
    ): HeroAttribute()

    data class Strength(
        val value: String = "Strength"
    ): HeroAttribute()

    data class Intelligence(
        val value: String = "Intelligence"
    ): HeroAttribute()
}
