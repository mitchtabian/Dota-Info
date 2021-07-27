package com.codingwithmitch.dotainfo.hero_interactors.interactors

import com.codingwithmitch.core.domain.DataState
import com.codingwithmitch.core.domain.ProgressBarState
import com.codingwithmitch.core.domain.UIComponent
import com.codingwithmitch.dotainfo.hero_domain.Hero
import com.codingwithmitch.dotainfo.hero_interactors.GetHeros
import com.codingwithmitch.dotainfo.hero_interactors.datasource.cache.HeroCacheFake
import com.codingwithmitch.dotainfo.hero_interactors.datasource.cache.HeroDatabaseFake
import com.codingwithmitch.dotainfo.hero_interactors.datasource.network.HeroServiceFake
import com.codingwithmitch.dotainfo.hero_interactors.datasource.network.HeroServiceResponseType
import com.codingwithmitch.dotainfo.hero_interactors.datasource.network.data.HeroDataValid.NUM_HEROS
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * 1. Success (Retrieve a list of heros)
 * 2. Failure (Retrieve an empty list of heros)
 * 3. Failure (Retrieve malformed data)
 */
class GetHerosTest {

    // system in test
    private lateinit var getHeros: GetHeros

    @Test
    fun getHeros_success() =  runBlocking {
        // setup
        val heroDatabase = HeroDatabaseFake()
        val heroCache = HeroCacheFake(heroDatabase)
        val heroService = HeroServiceFake.build(
            type = HeroServiceResponseType.GoodData // good data
        )

        getHeros = GetHeros(
            cache = heroCache,
            service = heroService
        )

        // Confirm the cache is empty before any use-cases have been executed
        var cachedHeros = heroCache.selectAll()
        assert(cachedHeros.isEmpty())

        // Execute the use-case
        val emissions = getHeros.execute().toList()

        // First emission should be loading
        assert(emissions[0] == DataState.Loading<List<Hero>>(ProgressBarState.Loading))

        // Confirm second emission is data
        assert(emissions[1] is DataState.Data)
        assert((emissions[1] as DataState.Data).data?.size?: 0 == NUM_HEROS)

        // Confirm the cache is no longer empty
        cachedHeros = heroCache.selectAll()
        assert(cachedHeros.size == NUM_HEROS)

        // Confirm loading state is IDLE
        assert(emissions[2] == DataState.Loading<List<Hero>>(ProgressBarState.Idle))
    }

    @Test
    fun getHeros_emptyList() =  runBlocking {
        // setup
        val heroDatabase = HeroDatabaseFake()
        val heroCache = HeroCacheFake(heroDatabase)
        val heroService = HeroServiceFake.build(
            type = HeroServiceResponseType.EmptyList // Empty List
        )

        getHeros = GetHeros(
            cache = heroCache,
            service = heroService
        )

        // Confirm the cache is empty before any use-cases have been executed
        var cachedHeros = heroCache.selectAll()
        assert(cachedHeros.isEmpty())

        // Execute the use-case
        val emissions = getHeros.execute().toList()

        // First emission should be loading
        assert(emissions[0] == DataState.Loading<List<Hero>>(ProgressBarState.Loading))

        // Confirm second emission is data (empty list)
        assert(emissions[1] is DataState.Data)
        assert((emissions[1] as DataState.Data).data?.size?: 0 == 0)

        // Confirm the cache is STILL EMPTY
        cachedHeros = heroCache.selectAll()
        assert(cachedHeros.size == 0)

        // Confirm loading state is IDLE
        assert(emissions[2] == DataState.Loading<List<Hero>>(ProgressBarState.Idle))
    }

    @Test
    fun getHeros_malformedData() =  runBlocking {
        // setup
        val heroDatabase = HeroDatabaseFake()
        val heroCache = HeroCacheFake(heroDatabase)
        val heroService = HeroServiceFake.build(
            type = HeroServiceResponseType.MalformedData // Malformed data
        )

        getHeros = GetHeros(
            cache = heroCache,
            service = heroService
        )

        // Confirm the cache is empty before any use-cases have been executed
        var cachedHeros = heroCache.selectAll()
        assert(cachedHeros.isEmpty())

        // Execute the use-case
        val emissions = getHeros.execute().toList()

        // First emission should be loading
        assert(emissions[0] == DataState.Loading<List<Hero>>(ProgressBarState.Loading))

        // Confirm second emission is error response
        assert(emissions[1] is DataState.Response)
        assert(((emissions[1] as DataState.Response).uiComponent as UIComponent.Dialog).title == "Network Data Error")
        assert(((emissions[1] as DataState.Response).uiComponent as UIComponent.Dialog).description.contains("Unexpected JSON token at offset"))

        // Confirm third emission is empty list of data
        assert(emissions[2] is DataState.Data)
        assert((emissions[2] as DataState.Data).data?.size == 0)

        // Confirm the cache is STILL EMPTY
        cachedHeros = heroCache.selectAll()
        assert(cachedHeros.isEmpty())

        // Confirm loading state is IDLE
        assert(emissions[3] == DataState.Loading<List<Hero>>(ProgressBarState.Idle))
    }

}

















