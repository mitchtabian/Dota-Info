package com.codingwithmitch.topplayerinteractors

import com.codingwithmitch.core.domain.DataState
import com.codingwithmitch.core.domain.ProgressBarState
import com.codingwithmitch.core.domain.UIComponent
import com.codingwithmitch.player.Player
import com.codingwithmitch.topplayerservice.TopPlayerService
import com.codingwithmitch.topplayerservice.model.toPlayer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @param service: service gets network data.
 * @param requestLimit: Free tier API only allows 60 requestLimit requests / minute so need to limit.
 */
class GetPlayers(
    private val service: TopPlayerService,
    private val requestLimit: Int = 30,
) {

    fun execute(): Flow<DataState<List<Player>>> =  flow {
        // show loading state
        emit(DataState.Loading(ProgressBarState.Loading))
        try {
            // get the id's
            val playersByRank = service.getAccountIds()

            // use the id's to search each individual player
            val players: MutableList<Player> = mutableListOf()

            val maxIndex = if(playersByRank.size > requestLimit) requestLimit else playersByRank.size - 1
            for(index in 0 .. maxIndex){
                try {
                    val player = service.getPlayerDto(playersByRank.get(index).accountId).toPlayer()
                    if(player != null){
                        players.add(player)
                    }
                }catch (e: Exception){
                    e.printStackTrace()
                    emit(DataState.Response<List<Player>>(
                        uiComponent = UIComponent.None(
                            message = e.message ?: "Error retrieving player details."
                        )
                    ))
                }
            }
            emit(DataState.Data<List<Player>>(data = players))
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

    companion object Factory{
        fun build(): GetPlayers{
            return GetPlayers(
                service = TopPlayerService.build()
            )
        }
    }
}
















