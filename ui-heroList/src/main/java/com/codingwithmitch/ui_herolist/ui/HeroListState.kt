package com.codingwithmitch.ui_herolist.ui

import com.codingwithmitch.core.domain.*
import com.codingwithmitch.dotainfo.hero_domain.Hero
import com.codingwithmitch.ui_herolist.util.HeroFilter

data class HeroListState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val heros: List<Hero> = listOf(),
    val filterDialogState: UIComponentState = UIComponentState.Hide, // show/hide the filter dialog
    val heroFilter: HeroFilter = HeroFilter.Hero(SqlFilterOrder.Descending),
    val errorQueue: Queue<UIComponent> = Queue(mutableListOf())
)
