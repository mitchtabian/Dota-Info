package com.codingwithmitch.ui_herolist.ui

import com.codingwithmitch.core.domain.UIComponent
import com.codingwithmitch.core.domain.UIComponentState
import com.codingwithmitch.dotainfo.hero_domain.HeroAttribute
import com.codingwithmitch.dotainfo.hero_domain.HeroFilter

sealed class HeroListEvents{

    object GetHeros: HeroListEvents()

    object FilterHeros: HeroListEvents()

    data class UpdateHeroName(
        val heroName: String,
    ): HeroListEvents()

    data class UpdateHeroFilter(
        val heroFilter: HeroFilter
    ): HeroListEvents()

    data class UpdateAttributeFilter(
        val attribute: HeroAttribute
    ): HeroListEvents()

    data class UpdateFilterDialogState(
        val uiComponentState: UIComponentState
    ): HeroListEvents()

    object OnRemoveHeadFromQueue: HeroListEvents()

    data class Error(
        val uiComponent: UIComponent
    ): HeroListEvents()
}
