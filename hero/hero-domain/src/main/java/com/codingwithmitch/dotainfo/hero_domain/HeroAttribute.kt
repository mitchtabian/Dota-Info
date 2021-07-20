package com.codingwithmitch.dotainfo.hero_domain

sealed class HeroAttribute(
    val uiValue: String,
    val abbreviation: String,
){
    object Agility: HeroAttribute(
        uiValue = "Agility",
        abbreviation = "agi",
    )

   object Strength: HeroAttribute(
       uiValue = "Strength",
       abbreviation = "str",
   )

    object Intelligence: HeroAttribute(
        uiValue = "Intelligence",
        abbreviation = "int",
    )

    object Unknown: HeroAttribute(
        uiValue = "Unknown",
        abbreviation = "unknown",
    )
}

fun getHeroAttrFromUiValue(uiValue: String): HeroAttribute{
    return when(uiValue){
        HeroAttribute.Agility.uiValue -> {
            HeroAttribute.Agility
        }
        HeroAttribute.Strength.uiValue -> {
            HeroAttribute.Strength
        }
        HeroAttribute.Intelligence.uiValue -> {
            HeroAttribute.Intelligence
        }
        else -> HeroAttribute.Unknown
    }
}

fun getHeroAttrFromAbreviation(abbreviation: String): HeroAttribute{
    return when(abbreviation){
        HeroAttribute.Agility.abbreviation -> {
            HeroAttribute.Agility
        }
        HeroAttribute.Strength.abbreviation -> {
            HeroAttribute.Strength
        }
        HeroAttribute.Intelligence.abbreviation -> {
            HeroAttribute.Intelligence
        }
        else -> HeroAttribute.Unknown
    }
}














