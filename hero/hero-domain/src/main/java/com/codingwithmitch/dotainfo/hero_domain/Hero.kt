package com.codingwithmitch.dotainfo.hero_domain

data class Hero(
    val id: Int,
    val localizedName: String,
    val primaryAttribute: HeroAttribute,
    val attackType: HeroAttackType,
    val roles: List<HeroRole>,
    val img: String,
    val icon: String,
    val baseHealth: Long,
    val baseHealthRegen: Long?,
    val baseMana: Long,
    val baseManaRegen: Long?,
    val baseArmor: Long,
    val baseMoveRate: Long,
    val baseAttackMin: Int,
    val baseAttackMax: Int,
    val baseStr: Int,
    val baseAgi: Int,
    val baseInt: Int,
    val strGain: Long, // Strength gain per lvl
    val agiGain: Long, // Agility gain per lvl
    val intGain: Long, // Intelligence gain per lvl
    val attackRange: Int,
    val projectileSpeed: Int,
    val attackRate: Long,
    val moveSpeed: Int,
    val turnRate: Long? = 0L,
    val legs: Int, // How many legs does this hero have?
    val turboPicks: Int, // How many times picked for turbo matches?
    val turboWins: Int, // How many times won a turbo match?
    val proWins: Int, // How many times won a pro match?
    val proPick: Int, // How many times picked in pro match?
    val firstPick: Int, // How many times picked first?
    val firstWin: Int, // How many times picked first and won?
    val secondPick: Int, // How many times picked second?
    val secondWin: Int, // How many times picked second and won?
    val thirdPick: Int, // How many times picked third?
    val thirdWin: Int, // How many times picked third and won?
    val fourthPick: Int, // How many times picked in fourth round?
    val fourthWin: Int, // How many times picked in fourth round and won?
    val fifthPick: Int, // How many times picked fifth?
    val fifthWin: Int, // How many times picked fifth and won?
    val sixthPick: Int, // How many times picked sixth?
    val sixthWin: Int, // How many times picked sixth and won?
    val seventhPick: Int, // How many times picked seventh?
    val seventhWin: Int, // How many times picked seventh and won?
    val eighthPick: Int, // How many times picked eighth round?
    val eighthWin: Int, // How many times picked eighth and won?
)













