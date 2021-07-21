package com.codingwithmitch.ui_herolist

import com.codingwithmitch.core.domain.ProgressBarState
import com.codingwithmitch.core.domain.Queue
import com.codingwithmitch.core.domain.UIComponent
import com.codingwithmitch.dotainfo.hero_domain.Hero

data class HeroListState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val heros: List<Hero> = listOf(),
    val queue: Queue<UIComponent> = Queue(mutableListOf())
)
