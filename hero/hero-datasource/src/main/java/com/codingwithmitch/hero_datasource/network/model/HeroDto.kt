package com.codingwithmitch.hero_datasource.network.model

import com.codingwithmitch.hero_datasource.network.EndPoints.BASE_URL
import com.codingwithmitch.hero_domain.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HeroDto(

    @SerialName("id")
    val id: Int,

    @SerialName("localized_name")
    val localizedName: String,

    @SerialName("primary_attr")
    val primaryAttribute: String,

    @SerialName("attack_type")
    val attackType: String,

    @SerialName("roles")
    val roles: List<String>,

    @SerialName("img")
    val img: String,

    @SerialName("icon")
    val icon: String,

    @SerialName("base_health")
    val baseHealth: Float,

    @SerialName("base_health_regen")
    val baseHealthRegen: Float?,

    @SerialName("base_mana")
    val baseMana: Float,

    @SerialName("base_mana_regen")
    val baseManaRegen: Float?,

    @SerialName("base_armor")
    val baseArmor: Float,

    @SerialName("base_mr")
    val baseMoveRate: Float,

    @SerialName("base_attack_min")
    val baseAttackMin: Int,

    @SerialName("base_attack_max")
    val baseAttackMax: Int,

    @SerialName("base_str")
    val baseStr: Int,

    @SerialName("base_agi")
    val baseAgi: Int,

    @SerialName("base_int")
    val baseInt: Int,

    @SerialName("str_gain")
    val strGain: Float, // Strength gain per lvl

    @SerialName("agi_gain")
    val agiGain: Float, // Agility gain per lvl

    @SerialName("int_gain")
    val intGain: Float, // Intelligence gain per lvl

    @SerialName("attack_range")
    val attackRange: Int,

    @SerialName("projectile_speed")
    val projectileSpeed: Int,

    @SerialName("attack_rate")
    val attackRate: Float,

    @SerialName("move_speed")
    val moveSpeed: Int,

    @SerialName("turn_rate")
    val turnRate: Float? = 0F,

    @SerialName("legs")
    val legs: Int, // How many legs does this hero have?

    @SerialName("turbo_picks")
    val turboPicks: Int, // How many times picked for turbo matches?

    @SerialName("turbo_wins")
    val turboWins: Int, // How many times won a turbo match?

    @SerialName("pro_win")
    val proWins: Int? = 0, // How many times won a pro match?

    @SerialName("pro_pick")
    val proPick: Int? = 0, // How many times picked in pro match?

    @SerialName("1_pick")
    val firstPick: Int, // How many times picked first?

    @SerialName("1_win")
    val firstWin: Int, // How many times picked first and won?

    @SerialName("2_pick")
    val secondPick: Int, // How many times picked second?

    @SerialName("2_win")
    val secondWin: Int, // How many times picked second and won?

    @SerialName("3_pick")
    val thirdPick: Int, // How many times picked third?

    @SerialName("3_win")
    val thirdWin: Int, // How many times picked third and won?

    @SerialName("4_pick")
    val fourthPick: Int, // How many times picked in fourth round?

    @SerialName("4_win")
    val fourthWin: Int, // How many times picked in fourth round and won?

    @SerialName("5_pick")
    val fifthPick: Int, // How many times picked fifth?

    @SerialName("5_win")
    val fifthWin: Int, // How many times picked fifth and won?

    @SerialName("6_pick")
    val sixthPick: Int, // How many times picked sixth?

    @SerialName("6_win")
    val sixthWin: Int, // How many times picked sixth and won?

    @SerialName("7_pick")
    val seventhPick: Int, // How many times picked seventh?

    @SerialName("7_win")
    val seventhWin: Int, // How many times picked seventh and won?

    @SerialName("8_pick")
    val eighthPick: Int, // How many times picked eighth round?

    @SerialName("8_win")
    val eighthWin: Int, // How many times picked eighth and won?
)

fun HeroDto.toHero(): Hero{
    return Hero(
        id = id,
        localizedName = localizedName,
        primaryAttribute = getHeroAttrFromAbreviation(primaryAttribute),
        attackType = getHeroAttackType(attackType),
        roles = roles.map { getHeroRole(it) },
        img = "$BASE_URL$img",
        icon = "$BASE_URL$icon",
        baseHealth = baseHealth,
        baseHealthRegen = baseHealthRegen,
        baseMana = baseMana,
        baseManaRegen = baseManaRegen,
        baseArmor = baseArmor,
        baseMoveRate = baseMoveRate,
        baseAttackMin = baseAttackMin,
        baseAttackMax = baseAttackMax,
        baseStr = baseStr,
        baseAgi = baseAgi,
        baseInt = baseInt,
        strGain = strGain,
        agiGain = agiGain,
        intGain = intGain,
        attackRange = attackRange,
        projectileSpeed = projectileSpeed,
        attackRate = attackRate,
        moveSpeed = moveSpeed,
        turnRate = turnRate,
        legs = legs,
        turboPicks = turboPicks,
        turboWins = turboWins,
        proWins = proWins ?: 0,
        proPick = proPick?: 0,
        firstPick = firstPick,
        firstWin = firstWin,
        secondPick = secondPick,
        secondWin = secondWin,
        thirdPick = thirdPick,
        thirdWin = thirdWin,
        fourthPick = fourthPick,
        fourthWin = fourthWin,
        fifthPick = fifthPick,
        fifthWin = fifthWin,
        sixthPick = sixthPick,
        sixthWin = sixthWin,
        seventhPick = seventhPick,
        seventhWin = seventhWin,
        eighthWin = eighthWin,
        eighthPick = eighthPick,
    )
}





















