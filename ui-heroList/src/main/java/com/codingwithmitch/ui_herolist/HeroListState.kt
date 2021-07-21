package com.codingwithmitch.ui_herolist

import com.codingwithmitch.core.domain.ProgressBarState
import com.codingwithmitch.dotainfo.hero_domain.Hero

data class HeroListState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val heros: List<Hero> = listOf(),
)
