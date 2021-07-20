package com.codingwithmitch.dotainfo.hero_datasource.cache

import android.content.Context
import com.codingwithmitch.dotainfo.hero_domain.Hero
import com.squareup.sqldelight.android.AndroidSqliteDriver

interface HeroCache {

    suspend fun getHero(id: Int): Hero

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
        fun build(context: Context): HeroCache {
            return HeroCacheImpl(
                HeroDatabase(
                    AndroidSqliteDriver(
                        HeroDatabase.Schema,
                        context,
                        "heros.db"
                    )
                )
            )
        }
    }
}



















