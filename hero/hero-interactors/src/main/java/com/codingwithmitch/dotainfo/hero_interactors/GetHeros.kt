package com.codingwithmitch.dotainfo.hero_interactors

import com.codingwithmitch.core.domain.DataState
import com.codingwithmitch.core.domain.UIComponent
import com.codingwithmitch.dotainfo.hero_datasource.cache.HeroCache
import com.codingwithmitch.dotainfo.hero_datasource.network.HeroService
import com.codingwithmitch.dotainfo.hero_domain.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetHeros(
    private val cache: HeroCache,
    private val service: HeroService,
) {

    fun execute(): Flow<DataState<List<Hero>>> = flow {
        try {
            val heros = service.getHeroStats()
            emit(DataState.Data(heros))
        }catch (e: Exception){
            e.printStackTrace()
            emit(DataState.Response<List<Hero>>(
                uiComponent = UIComponent.Dialog(
                    title = "Error",
                    description = e.message?: "Unknown error"
                )
            ))
        }

    }
}




