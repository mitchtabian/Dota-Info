package com.codingwithmitch.hero_interactors

import com.codingwithmitch.hero_datasource.cache.HeroCache
import com.codingwithmitch.hero_datasource.network.HeroService
import com.squareup.sqldelight.db.SqlDriver

data class HeroInteractors(
    val getHeros: GetHeros,
    val filterHeros: FilterHeros,
    val getHeroFromCache: GetHeroFromCache,
) {
    companion object Factory {
        fun build(sqlDriver: SqlDriver): HeroInteractors{
            val service = HeroService.build()
            val heroCache = HeroCache.build(sqlDriver)
            return HeroInteractors(
                getHeros = GetHeros(
                    cache = heroCache,
                    service = service,
                ),
                filterHeros = FilterHeros(),
                getHeroFromCache = GetHeroFromCache(
                    cache = heroCache
                ),
            )
        }

        fun schema(): SqlDriver.Schema {
            return HeroCache.schema()
        }

        fun dbName(): String {
            return HeroCache.dbName()
        }
    }
}









