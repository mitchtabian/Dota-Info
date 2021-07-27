package com.codingwithmitch.dotainfo.hero_datasource.cache

import com.codingwithmitch.dotainfo.hero_domain.Hero
import com.squareup.sqldelight.db.SqlDriver

interface HeroCache {

    suspend fun getHero(id: Int): Hero?

    suspend fun selectAll(): List<Hero>

    suspend fun insert(hero: Hero)

    suspend fun insert(heros: List<Hero>)

    suspend fun searchByName(localizedName: String): List<Hero>

    suspend fun searchByAttr(primaryAttr: String): List<Hero>

    suspend fun searchByAttackType(attackType: String): List<Hero>

    // Can select multiple roles
    suspend fun searchByRole(
        carry: Boolean = false,
        escape: Boolean = false,
        nuker: Boolean = false,
        initiator: Boolean = false,
        durable: Boolean = false,
        disabler: Boolean = false,
        jungler: Boolean = false,
        support: Boolean = false,
        pusher: Boolean = false,
    ): List<Hero>

    companion object Factory {
        fun build(sqlDriver: SqlDriver): HeroCache {
            return HeroCacheImpl(HeroDatabase(sqlDriver))
        }
        fun schema(): SqlDriver.Schema {
            return HeroDatabase.Schema
        }

        fun dbName(): String {
            return "heros.db"
        }
    }

}



















