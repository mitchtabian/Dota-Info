package com.codingwithmitch.ui_herodetail.ui

import com.codingwithmitch.core.domain.ProgressBarState
import com.codingwithmitch.hero_domain.Hero

data class HeroDetailState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val hero: Hero? = null,
)