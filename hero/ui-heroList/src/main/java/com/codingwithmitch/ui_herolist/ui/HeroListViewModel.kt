package com.codingwithmitch.ui_herolist.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.core.domain.DataState
import com.codingwithmitch.core.domain.UIComponent
import com.codingwithmitch.core.util.Logger
import com.codingwithmitch.hero_interactors.GetHeros
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
        }
    }

    private fun getHeros(){
        getHeros.execute().onEach { dataState ->
            when(dataState){
                is DataState.Response -> {
                    when(dataState.uiComponent){
                        is UIComponent.Dialog -> {
                            logger.log((dataState.uiComponent as UIComponent.Dialog).description)
                        }
                        is UIComponent.None -> {
                            logger.log((dataState.uiComponent as UIComponent.None).message)
                        }
                    }
                }
                is DataState.Data -> {
                    state.value = state.value.copy(heros = dataState.data?: listOf())
                }
                is DataState.Loading -> {
                    state.value = state.value.copy(progressBarState = dataState.progressBarState)
                }
            }
        }.launchIn(viewModelScope)
    }
}













