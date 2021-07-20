package com.codingwithmitch.dotainfo.hero_domain

sealed class HeroAttackType{

    data class Melee(
        val value: String = "Melee"
    ): HeroAttackType()

    data class Ranged(
        val value: String = "Ranged"
    ): HeroAttackType()
}
