package com.codingwithmitch.ui_herolist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HeroList(
    state: HeroListState,
    events: (HeroListEvents) -> Unit,
    navigateToDetailScreen: (Int) -> Unit,
){
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(state.heros){ hero ->
            Text(
                modifier = Modifier.clickable {
                    navigateToDetailScreen(hero.id)
                },
                text = hero.localizedName
            )
        }
    }
}






