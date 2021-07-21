package com.codingwithmitch.ui_herolist

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.codingwithmitch.components.DefaultScreenUI
import com.codingwithmitch.ui_herolist.components.HeroListItem

@ExperimentalAnimationApi
@Composable
fun HeroList(
    state: HeroListState,
    events: (HeroListEvents) -> Unit,
    navigateToDetailScreen: (Int) -> Unit,
){
    DefaultScreenUI(
        queue = state.errorQueue,
        onRemoveHeadFromQueue = {
            events(HeroListEvents.OnRemoveHeadFromQueue)
        },
        progressBarState = state.progressBarState,
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.heros){ hero ->
                HeroListItem(
                    hero = hero,
                    onSelectHero = navigateToDetailScreen
                )
            }
        }
    }
}








