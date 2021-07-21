package com.codingwithmitch.ui_herodetail

import com.codingwithmitch.core.domain.ProgressBarState
import com.codingwithmitch.dotainfo.hero_domain.Hero

data class HeroDetailState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val hero: Hero? = null,
)
