package com.codingwithmitch.ui_herodetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.codingwithmitch.components.DefaultScreenUI

@Composable
fun HeroDetail(
    state: HeroDetailState,
    events: (HeroDetailEvents) -> Unit,
){
    DefaultScreenUI(
        queue = state.queue,
        onRemoveHeadFromQueue = {
            TODO("")
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            Text(
                text = state.hero?.localizedName?: "Unknown Hero name"
            )
        }
    }

}










