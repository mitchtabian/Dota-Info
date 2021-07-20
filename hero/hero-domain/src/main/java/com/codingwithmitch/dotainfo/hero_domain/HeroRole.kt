package com.codingwithmitch.dotainfo.hero_domain

sealed class HeroRole{

    data class Carry(
        val value: String = "Carry"
    ): HeroRole()

    data class Escape(
        val value: String = "Escape"
    ): HeroRole()

    data class Nuker(
        val value: String = "Nuker"
    ): HeroRole()

    data class Initiator(
        val value: String = "Initiator"
    ): HeroRole()

    data class Durable(
        val value: String = "Durable"
    ): HeroRole()

    data class Disabler(
        val value: String = "Disabler"
    ): HeroRole()

    data class Jungler(
        val value: String = "Jungler"
    ): HeroRole()

    data class Support(
        val value: String = "Support"
    ): HeroRole()

    data class Pusher(
        val value: String = "Pusher"
    ): HeroRole()


}











