package com.codingwithmitch.ui_herolist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.core.domain.DataState
import com.codingwithmitch.core.domain.Queue
import com.codingwithmitch.core.domain.UIComponent
import com.codingwithmitch.core.util.Logger
import com.codingwithmitch.dotainfo.hero_interactors.GetHeros
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HeroListViewModel
@Inject
constructor(
    private val getHeros: GetHeros,
    private val logger: Logger,
): ViewModel(){

    val state: MutableState<HeroListState> = mutableStateOf(HeroListState())

    init {
        onTriggerEvent(HeroListEvents.GetHeros)
    }

    fun onTriggerEvent(event: HeroListEvents){
        when(event){
            is HeroListEvents.GetHeros -> {
                getHeros()
            }
            is HeroListEvents.Error -> {
                if(event.uiComponent is UIComponent.None){
                    logger.log("getHeros: ${(event.uiComponent as UIComponent.None).message}")
                }
                else{
                    appendToMessageQueue(event.uiComponent)
                }
            }
        }
    }

    private fun getHeros(){
        getHeros.execute().onEach { dataState ->
            when(dataState){
                is DataState.Loading -> {
                    state.value = state.value.copy(progressBarState = dataState.progressBarState)
                }
                is DataState.Data -> {
                    state.value = state.value.copy(heros = dataState.data?: listOf())
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
        val queue = state.value.queue
        queue.add(uiComponent)
        state.value = state.value.copy(queue = Queue(mutableListOf())) // force recompose
        state.value = state.value.copy(queue = queue)
    }
}












