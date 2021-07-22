package com.codingwithmitch.ui_herolist.ui

import com.codingwithmitch.core.domain.UIComponent
import com.codingwithmitch.core.domain.UIComponentState
import com.codingwithmitch.ui_herolist.util.HeroFilter

sealed class HeroListEvents{

    object GetHeros: HeroListEvents()

    data class UpdateHeroFilter(
        val heroFilter: HeroFilter
    ): HeroListEvents()

    data class UpdateFilterDialogState(
        val uiComponentState: UIComponentState
    ): HeroListEvents()

    object OnRemoveHeadFromQueue: HeroListEvents()

    data class Error(
        val uiComponent: UIComponent
    ): HeroListEvents()
}
