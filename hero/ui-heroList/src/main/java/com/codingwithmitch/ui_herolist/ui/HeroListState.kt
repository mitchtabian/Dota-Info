package com.codingwithmitch.ui_herolist.ui

import com.codingwithmitch.core.domain.FilterOrder
import com.codingwithmitch.core.domain.ProgressBarState
import com.codingwithmitch.core.domain.UIComponentState
import com.codingwithmitch.hero_domain.Hero
import com.codingwithmitch.hero_domain.HeroAttribute
import com.codingwithmitch.hero_domain.HeroFilter

data class HeroListState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val heros: List<Hero> = listOf(),
    val filteredHeros: List<Hero> = listOf(),
    val heroName: String = "",
    val heroFilter: HeroFilter = HeroFilter.Hero(FilterOrder.Descending),
    val primaryAttrFilter: HeroAttribute = HeroAttribute.Unknown,
    val filterDialogState: UIComponentState = UIComponentState.Hide, // show/hide the filter dialog
)
