package com.codingwithmitch.dotainfo.hero_datasource.network

import com.codingwithmitch.dotainfo.hero_datasource.network.model.HeroDto
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

interface HeroService {

    suspend fun getHeroStats(): List<HeroDto>

    companion object Factory {
        fun build(): HeroService {
            return HeroServiceImpl(
                httpClient = HttpClient(Android) {
                    install(JsonFeature) {
                        serializer = KotlinxSerializer(
                            kotlinx.serialization.json.Json  {
                                ignoreUnknownKeys = true // if the server sends extra fields, ignore them
                            }
                        )
                    }
                }
            )
        }
    }
}