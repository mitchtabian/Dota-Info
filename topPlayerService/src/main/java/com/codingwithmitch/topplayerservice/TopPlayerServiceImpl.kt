package com.codingwithmitch.topplayerservice

import com.codingwithmitch.topplayerservice.EndPoints.PLAYERS
import com.codingwithmitch.topplayerservice.EndPoints.PLAYERS_BY_RANK
import com.codingwithmitch.topplayerservice.model.PlayerByRankDto
import com.codingwithmitch.topplayerservice.model.TopPlayerDto
import io.ktor.client.*
import io.ktor.client.request.*

class TopPlayerServiceImpl(
    private val httpClient: HttpClient,
): TopPlayerService {

    suspend override fun getAccountIds(): List<PlayerByRankDto> {
        return httpClient.get{
            url(PLAYERS_BY_RANK)
        }
    }

    suspend override fun getPlayerDto(accountId: Int): TopPlayerDto {
        return httpClient.get{
            url("$PLAYERS/${accountId}")
        }
    }

}










