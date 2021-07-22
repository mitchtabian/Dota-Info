package com.codingwithmitch.ui_herodetail.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.core.domain.DataState
import com.codingwithmitch.core.domain.Queue
import com.codingwithmitch.core.domain.UIComponent
import com.codingwithmitch.core.util.Logger
import com.codingwithmitch.dotainfo.hero_interactors.GetHeroFromCache
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HeroDetailViewModel
@Inject
constructor(
    private val getHeroFromCache: GetHeroFromCache,
    private val savedStateHandle: SavedStateHandle,
    private val logger: Logger,
): ViewModel(){

    val state: MutableState<HeroDetailState> = mutableStateOf(HeroDetailState())

    init {
        savedStateHandle.get<Int>("heroId")?.let { heroId ->
            onTriggerEvent(HeroDetailEvents.GetHeroFromCache(heroId))
        }?: showError(
            uiComponent = UIComponent.Dialog(
                title = "Error",
                description = "Unable to retrieve the details for this hero."
            )
        )
    }

    fun onTriggerEvent(event: HeroDetailEvents){
        when(event){
            is HeroDetailEvents.GetHeroFromCache -> {
                getHeroFromCache(event.id)
            }
            is HeroDetailEvents.OnRemoveHeadFromQueue -> {
                removeHeadMessage()
            }
            is HeroDetailEvents.Error -> {
                if(event.uiComponent is UIComponent.None){
                    logger.log("getHeros: ${(event.uiComponent as UIComponent.None).message}")
                }
                else{
                    appendToMessageQueue(event.uiComponent)
                }
            }
        }
    }

    private fun showError(uiComponent: UIComponent){
        onTriggerEvent(
            HeroDetailEvents.Error(
                uiComponent = uiComponent
            )
        )
    }

    private fun getHeroFromCache(id: Int){
        getHeroFromCache.execute(id).onEach { dataState ->
            when(dataState){
                is DataState.Loading -> {
                    state.value = state.value.copy(progressBarState = dataState.progressBarState)
                }
                is DataState.Data -> {
                    state.value = state.value.copy(hero = dataState.data)
                }
                is DataState.Response -> {
                    if(dataState.uiComponent is UIComponent.None){
                        logger.log("getHeros: ${(dataState.uiComponent as UIComponent.None).message}")
                    }
                    else{
                        appendToMessageQueue(dataState.uiComponent)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun appendToMessageQueue(uiComponent: UIComponent){
        val queue = state.value.errorQueue
        queue.add(uiComponent)
        state.value = state.value.copy(errorQueue = Queue(mutableListOf())) // force recompose
        state.value = state.value.copy(errorQueue = queue)
    }

    private fun removeHeadMessage() {
        try {
            val queue = state.value.errorQueue
            queue.remove() // can throw exception if empty
            state.value = state.value.copy(errorQueue = Queue(mutableListOf())) // force recompose
            state.value = state.value.copy(errorQueue = queue)
        }catch (e: Exception){
            logger.log("Nothing to remove from DialogQueue")
        }
    }
}












