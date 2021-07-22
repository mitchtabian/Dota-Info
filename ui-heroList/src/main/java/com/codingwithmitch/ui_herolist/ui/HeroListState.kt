package com.codingwithmitch.ui_herolist.ui

import com.codingwithmitch.core.domain.*
import com.codingwithmitch.dotainfo.hero_domain.Hero
import com.codingwithmitch.dotainfo.hero_domain.HeroAttribute
import com.codingwithmitch.dotainfo.hero_domain.HeroFilter

/**
 * @param progressBarState: State of the progress bar in UI.
 * @param heros: unfiltered list of heros.
 * @param filteredHeros: filtered list of heros.
 * @param filterDialogState: Show/hide the dialog with filter options
 * @param heroFilter: Filter heros by 'name' (asc / desc) or 'pro wins' (asc / desc)
 * @param primaryAttrFilter: Filter heros by their primary attribute
 * @param heroName: Filter heros by their name containing this string.
 * @param errorQueue: Errors (will be shown as dialog or none and logged)
 */
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
