package com.codingwithmitch.topplayerservice

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MmrEstimateDto(

    @SerialName("estimate")
    val estimate: Int? = null,
)
