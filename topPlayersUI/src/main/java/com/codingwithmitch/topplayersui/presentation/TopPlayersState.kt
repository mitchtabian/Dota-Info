package com.codingwithmitch.topplayersui.presentation

import com.codingwithmitch.core.domain.ProgressBarState
import com.codingwithmitch.core.domain.Queue
import com.codingwithmitch.core.domain.UIComponent
import com.codingwithmitch.player.Player

data class TopPlayersState(
    val progressState: ProgressBarState = ProgressBarState.Idle,
    val players: List<Player> = listOf(),
    val queue: Queue<UIComponent> = Queue(mutableListOf()),
)
