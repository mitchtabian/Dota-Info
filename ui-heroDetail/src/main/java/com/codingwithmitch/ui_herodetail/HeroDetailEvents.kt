package com.codingwithmitch.ui_herodetail

import com.codingwithmitch.core.domain.UIComponent

sealed class HeroDetailEvents{

    data class GetHeroFromCache(
        val id: Int,
    ): HeroDetailEvents()

    data class Error(
        val uiComponent: UIComponent
    ): HeroDetailEvents()
}
