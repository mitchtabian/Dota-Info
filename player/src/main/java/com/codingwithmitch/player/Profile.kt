package com.codingwithmitch.player

data class Profile(
    val accountId: Int,
    val personaName: String? = null,
    val name: String? = null,
    val steamId: String? = null,
    val avatar: String? = null,
    val avatarMedium: String? = null,
    val avatarFull: String? = null,
    val profileUrl: String? = null,
    val lastLogin: String? = null, // "2019-10-12T04:46:46.150Z"
    val locCountryCode: String? = null, // "CN"
)
