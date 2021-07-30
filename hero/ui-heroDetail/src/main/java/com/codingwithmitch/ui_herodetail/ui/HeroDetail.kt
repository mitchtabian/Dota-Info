package com.codingwithmitch.ui_herodetail.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun HeroDetail(
    state: HeroDetailState,
){
    Text(state.hero?.localizedName?: "LOADING")
}