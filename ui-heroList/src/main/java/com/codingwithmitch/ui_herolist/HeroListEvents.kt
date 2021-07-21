package com.codingwithmitch.ui_herolist

import com.codingwithmitch.core.domain.UIComponent

sealed class HeroListEvents{

    object GetHeros: HeroListEvents()

    data class Error(
        val uiComponent: UIComponent
    ): HeroListEvents()
}
