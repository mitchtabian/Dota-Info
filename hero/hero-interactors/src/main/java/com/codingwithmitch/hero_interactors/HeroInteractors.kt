package com.codingwithmitch.hero_interactors

import com.codingwithmitch.hero_datasource.cache.HeroCache
import com.codingwithmitch.hero_datasource.network.HeroService
import com.squareup.sqldelight.db.SqlDriver
import java.awt.Button

data class HeroInteractors(
    val getHeros: GetHeros,
    val getHeroFromCache: GetHeroFromCache,
    val filterHeros: FilterHeros,
) {
    companion object Factory {
        fun build(sqlDriver: SqlDriver): HeroInteractors{
            val service = HeroService.build()
            val cache = HeroCache.build(sqlDriver)
            return HeroInteractors(
                getHeros = GetHeros(
                    service = service,
                    cache = cache,
                ),
                getHeroFromCache = GetHeroFromCache(
                    cache = cache
                ),
                filterHeros = FilterHeros(),
            )
        }

        val schema: SqlDriver.Schema = HeroCache.schema

        val dbName: String = HeroCache.dbName
    }
}














