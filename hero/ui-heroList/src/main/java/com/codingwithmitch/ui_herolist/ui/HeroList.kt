package com.codingwithmitch.ui_herolist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.ImageLoader
import com.codingwithmitch.core.domain.ProgressBarState
import com.codingwithmitch.ui_herolist.components.HeroListItem
import com.codingwithmitch.ui_herolist.ui.HeroListState

@Composable
fun HeroList(
    state: HeroListState,
    imageLoader: ImageLoader,
){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ){
            items(state.heros){ hero ->
                HeroListItem(
                    hero = hero,
                    onSelectHero = {},
                    imageLoader = imageLoader,
                )
            }
        }
        if(state.progressBarState is ProgressBarState.Loading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}












