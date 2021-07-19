package com.codingwithmitch.topplayerservice

import com.codingwithmitch.topplayerservice.model.PlayerByRankDto
import com.codingwithmitch.topplayerservice.model.TopPlayerDto
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

interface TopPlayerService {

    suspend fun getAccountIds(): List<PlayerByRankDto>

    suspend fun getPlayerDto(accountId: Int): TopPlayerDto

    companion object Factory {
        fun build(): TopPlayerService {
            return TopPlayerServiceImpl(
                httpClient = HttpClient(Android) {
                    install(JsonFeature) {
                        serializer = KotlinxSerializer(
                            kotlinx.serialization.json.Json {
                                ignoreUnknownKeys = true // if the server sends extra fields, ignore them
                            }
                        )
                    }
                }
            )
        }
    }
}
