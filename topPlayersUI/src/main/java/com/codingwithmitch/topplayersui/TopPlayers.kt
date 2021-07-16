package com.codingwithmitch.topplayersui

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TopPlayers(
    //  state,
    // events,
    onSelectPlayer: (Int) -> Unit,
){
    val dummyPlayer =
    Text(
        modifier = Modifier.clickable {
            onSelectPlayer(1)
        },
        text = "Mitch Tabian"
    )
}