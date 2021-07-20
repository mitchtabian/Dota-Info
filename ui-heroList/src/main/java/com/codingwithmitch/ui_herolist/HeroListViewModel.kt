package com.codingwithmitch.ui_herolist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.core.domain.DataState
import com.codingwithmitch.core.domain.UIComponent
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
): ViewModel(){

    private val TAG: String = "AppDebug"

    init {
        getHeros.execute().onEach { dataState ->

            when(dataState){
                is DataState.Loading -> {
//                    state.value = state.value.copy(progressState = dataState.progressBarState)
                }
                is DataState.Data -> {
                    Log.d(TAG, "Data: ${dataState.data}")
//                    state.value = state.value.copy(players = dataState.data?: listOf())
                }
                is DataState.Response -> {
                    when(dataState.uiComponent){
                        is UIComponent.Dialog -> {
                            Log.d(TAG, "Data: ${(dataState.uiComponent as UIComponent.Dialog).description}")
                        }
                        is UIComponent.SnackBar -> {
                            Log.d(TAG, "Data: ${(dataState.uiComponent as UIComponent.SnackBar).text}")
                        }
                        is UIComponent.Toast -> {
                            Log.d(TAG, "Data: ${(dataState.uiComponent as UIComponent.Toast).text}")
                        }
                        is UIComponent.None -> {
                            Log.d(TAG, "Data: ${(dataState.uiComponent as UIComponent.None).message}")
                        }
                    }

//                    appendToMessageQueue(dataState.uiComponent)
                }
            }
        }.launchIn(viewModelScope)
    }
}












