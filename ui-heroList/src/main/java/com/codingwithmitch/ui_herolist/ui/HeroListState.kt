package com.codingwithmitch.ui_herolist.ui

import com.codingwithmitch.core.domain.*
import com.codingwithmitch.dotainfo.hero_domain.Hero
import com.codingwithmitch.dotainfo.hero_domain.HeroAttribute
import com.codingwithmitch.dotainfo.hero_domain.HeroFilter

data class HeroListState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val heros: List<Hero> = listOf(),
    val filteredHeros: List<Hero> = listOf(),
    val filterDialogState: UIComponentState = UIComponentState.Hide, // show/hide the filter dialog
    val heroFilter: HeroFilter = HeroFilter.Hero(FilterOrder.Descending),
    val primaryAttrFilter: HeroAttribute = HeroAttribute.Unknown,
    val heroName: String = "",
    val errorQueue: Queue<UIComponent> = Queue(mutableListOf())
)
