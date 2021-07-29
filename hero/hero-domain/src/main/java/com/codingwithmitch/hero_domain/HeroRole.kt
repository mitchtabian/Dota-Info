package com.codingwithmitch.hero_domain

sealed class HeroRole(
    val uiValue: String,
){

    object Carry: HeroRole(
        uiValue = "Carry"
    )

    object Escape: HeroRole(
        uiValue = "Escape"
    )

    object Nuker: HeroRole(
        uiValue = "Nuker"
    )

    object Initiator: HeroRole(
        uiValue = "Initiator"
    )

    object Durable: HeroRole(
        uiValue = "Durable"
    )

    object Disabler: HeroRole(
        uiValue = "Disabler"
    )

    object Jungler: HeroRole(
        uiValue = "Jungler"
    )

    object Support: HeroRole(
        uiValue = "Support"
    )

    object Pusher: HeroRole(
        uiValue = "Pusher"
    )

    object Unknown: HeroRole(
        uiValue = "Unknown"
    )
}

fun getHeroRole(uiValue: String): HeroRole{
    return when(uiValue){
        HeroRole.Carry.uiValue -> {
            HeroRole.Carry
        }
        HeroRole.Escape.uiValue -> {
            HeroRole.Escape
        }
        HeroRole.Nuker.uiValue -> {
            HeroRole.Nuker
        }
        HeroRole.Initiator.uiValue -> {
            HeroRole.Initiator
        }
        HeroRole.Durable.uiValue -> {
            HeroRole.Durable
        }
        HeroRole.Disabler.uiValue -> {
            HeroRole.Disabler
        }
        HeroRole.Jungler.uiValue -> {
            HeroRole.Jungler
        }
        HeroRole.Support.uiValue -> {
            HeroRole.Support
        }
        HeroRole.Pusher.uiValue -> {
            HeroRole.Pusher
        }
        else -> {
            HeroRole.Unknown
        }
    }
}