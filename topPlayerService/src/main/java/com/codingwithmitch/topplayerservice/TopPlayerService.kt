package com.codingwithmitch.topplayerservice

import com.codingwithmitch.topplayerservice.model.PlayerByRankDto
import com.codingwithmitch.topplayerservice.model.TopPlayerDto

interface TopPlayerService {

    suspend fun getAccountIds(): List<PlayerByRankDto>

    suspend fun getPlayerDto(accountId: Int): TopPlayerDto
}