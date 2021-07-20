package com.codingwithmitch.dotainfo.hero_datasource.network

import com.codingwithmitch.dotainfo.hero_datasource.network.model.HeroDto
import io.ktor.client.*
import io.ktor.client.request.*

class HeroServiceImpl(
    private val httpClient: HttpClient,
): HeroService {

    override suspend fun getHeroStats(): List<HeroDto> {
        return httpClient.get {
            url(EndPoints.HERO_STATS)
        }
    }
}