package com.codingwithmitch.ui_herolist.ui

import com.codingwithmitch.core.domain.ProgressBarState
import com.codingwithmitch.hero_domain.Hero

data class HeroListState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val heros: List<Hero> = listOf(),
    val filteredHeros: List<Hero> = listOf(),
    val heroName: String = "",
)
