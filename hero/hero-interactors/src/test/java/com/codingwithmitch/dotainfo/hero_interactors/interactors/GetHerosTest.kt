package com.codingwithmitch.dotainfo.hero_interactors.interactors

import com.codingwithmitch.dotainfo.hero_interactors.GetHeros
import com.codingwithmitch.dotainfo.hero_interactors.datasource.cache.HeroCacheFake
import com.codingwithmitch.dotainfo.hero_interactors.datasource.cache.HeroDatabaseFake
import com.codingwithmitch.dotainfo.hero_interactors.datasource.network.HeroServiceFake
import com.codingwithmitch.dotainfo.hero_interactors.datasource.network.HeroServiceResponseType
import kotlinx.coroutines.runBlocking
import org.junit.Test


class GetHerosTest {

    // system in test
    private lateinit var getHeros: GetHeros

    @Test
    fun getHeros_success() =  runBlocking {
        // setup
        val heroDatabase = HeroDatabaseFake()
        val heroCache = HeroCacheFake(heroDatabase)
        val heroService = HeroServiceFake.build(
            type = HeroServiceResponseType.GoodData
        )
        getHeros = GetHeros(
            cache = heroCache,
            service = heroService
        )

        // Confirm the cache is empty before any use-cases have been executed
        val cachedHeros = heroCache.selectAll()
        assert(cachedHeros.isEmpty())


    }

}

















