package com.codingwithmitch.ui_herodetail.ui

import com.codingwithmitch.core.domain.UIComponent

sealed class HeroDetailEvents{

    data class GetHeroFromCache(
        val id: Int,
    ): HeroDetailEvents()

    object OnRemoveHeadFromQueue: HeroDetailEvents()

    data class Error(
        val uiComponent: UIComponent
    ): HeroDetailEvents()
}
