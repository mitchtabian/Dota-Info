package com.codingwithmitch.topplayerservice.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data model for https://api.opendota.com/api/playersByRank
 */
@Serializable
data class PlayerByRankDto(
    @SerialName("account_id")
    val accountId: Int
)
