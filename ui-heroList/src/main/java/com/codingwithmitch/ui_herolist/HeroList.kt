package com.codingwithmitch.ui_herolist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.codingwithmitch.components.DefaultScreenUI
import com.codingwithmitch.core.domain.SnackbarDuration
import com.codingwithmitch.core.domain.UIComponent

@Composable
fun HeroList(
    state: HeroListState,
    events: (HeroListEvents) -> Unit,
    navigateToDetailScreen: (Int) -> Unit,
){
    DefaultScreenUI(
        queue = state.queue
    ) {
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

        // Testing snackbar
        Button(
            onClick = {
                events(HeroListEvents.Error(
                    uiComponent = UIComponent.SnackBar(
                        text = "Testing a snackbar",
                        duration = SnackbarDuration.SHORT
                    )
                ))
            }
        ) {
            Text("trigger")
        }
    }
}








