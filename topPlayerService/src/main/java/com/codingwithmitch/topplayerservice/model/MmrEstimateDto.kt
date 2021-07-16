package com.codingwithmitch.topplayerservice.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MmrEstimateDto(

    @SerialName("estimate")
    val estimate: Int? = null,
)
