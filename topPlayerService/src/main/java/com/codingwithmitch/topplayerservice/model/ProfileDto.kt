package com.codingwithmitch.topplayerservice.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileDto(

    @SerialName("account_id")
    val accountId: Int? = null,

    @SerialName("personaname")
    val personaName: String? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("steamid")
    val steamId: String? = null,

    @SerialName("avatar")
    val avatar: String? = null,

    @SerialName("avatarmedium")
    val avatarMedium: String? = null,

    @SerialName("avatarfull")
    val avatarFull: String? = null,

    @SerialName("profileurl")
    val profileUrl: String? = null,

    @SerialName("last_login")
    val lastLogin: String? = null, // "2019-10-12T04:46:46.150Z"

    @SerialName("loccountrycode")
    val locCountryCode: String? = null, // "CN"
)



















