package com.codingwithmitch.topplayersui.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.core.domain.DataState
import com.codingwithmitch.core.domain.Queue
import com.codingwithmitch.core.domain.UIComponent
import com.codingwithmitch.topplayerinteractors.GetPlayers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TopPlayersViewModel
@Inject
constructor(
    private val getPlayers: GetPlayers
): ViewModel() {

    private val TAG: String = "AppDebug"

    val state: MutableState<TopPlayersState> = mutableStateOf(TopPlayersState())

    init {
        onTriggerEvent(TopPlayersEvents.GetPlayers)
    }

    fun onTriggerEvent(event: TopPlayersEvents){
        when(event){
            is TopPlayersEvents.GetPlayers -> {
                getPlayers()
            }
        }
    }

    private fun getPlayers(){
        getPlayers.execute().onEach { dataState ->
            when(dataState){
                is DataState.Loading -> {
                    state.value = state.value.copy(progressState = dataState.progressBarState)
                }
                is DataState.Data -> {
                    state.value = state.value.copy(players = dataState.data?: listOf())
                }
                is DataState.Response -> {
                    appendToMessageQueue(dataState.uiComponent)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun appendToMessageQueue(uiComponent: UIComponent){
        val queue = state.value.queue
        var didAppend = true
        when(uiComponent){
            is UIComponent.Dialog ->{
                queue.add(uiComponent)
            }
            is UIComponent.Toast ->{
                queue.add(uiComponent)
            }
            is UIComponent.SnackBar ->{
                queue.add(uiComponent)
            }
            is UIComponent.None ->{
                didAppend = false
                // Log to Crashlytics or whatever you're using
                Log.d(TAG, "appendToMessageQueue: ${uiComponent.message}")
            }
        }
        if(didAppend){
            state.value = state.value.copy(queue = Queue(mutableListOf()))
            state.value = state.value.copy(queue = queue)
        }
    }
}















