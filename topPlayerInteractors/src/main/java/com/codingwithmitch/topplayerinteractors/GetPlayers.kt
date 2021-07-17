package com.codingwithmitch.topplayerinteractors

import com.codingwithmitch.constants.NetworkConstants.NETWORK_TIMEOUT
import com.codingwithmitch.core.domain.DataState
import com.codingwithmitch.core.domain.ProgressBarState
import com.codingwithmitch.core.domain.UIComponent
import com.codingwithmitch.player.Player
import com.codingwithmitch.topplayerservice.TopPlayerService
import com.codingwithmitch.topplayerservice.model.toPlayer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withTimeout

class GetPlayers(
    private val service: TopPlayerService,
) {

    fun execute(): Flow<DataState<List<Player>>> =  flow {
        // show loading state
        emit(DataState.Loading(ProgressBarState.Loading))
        try {
//            withTimeout(NETWORK_TIMEOUT){ // throws TimeoutCancellationException

                // get the id's
                val playersByRank = service.getAccountIds()

                // use the id's to search each individual player
                val players: MutableList<Player> = mutableListOf()
                for(index in 0 .. 2){
                    val player = service.getPlayerDto(playersByRank.get(index).accountId).toPlayer()
                    if(player != null){
                        players.add(player)
                    }
                }
            // I need an api key or something because the api limits me
//                for(account in playersByRank){
//                    val player = service.getPlayerDto(account.accountId).toPlayer()
//                    if(player != null){
//                        players.add(player)
//                    }
//                }
                emit(DataState.Data<List<Player>>(data = players))
//            }
        }catch (e: Exception){
            e.printStackTrace()
            emit(DataState.Response<List<Player>>(
                uiComponent = UIComponent.Dialog(
                    title = "Error",
                    description = e.message ?: "Unknown Error"
                )
            ))
        }finally {
            // Finish loading state
            emit(DataState.Loading(ProgressBarState.Idle))
        }
    }
}
















