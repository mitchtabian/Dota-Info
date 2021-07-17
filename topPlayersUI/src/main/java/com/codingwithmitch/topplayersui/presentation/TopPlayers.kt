package com.codingwithmitch.topplayersui.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.codingwithmitch.topplayersdetailui.navigation.TopPlayerDetailDestination

@Composable
fun TopPlayers(
    state: TopPlayersState,
    events: (TopPlayersEvents) -> Unit,
    navController: NavController,
){
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(state.players){ player ->
            Text(
                modifier = Modifier.clickable {
                    navController.navigate("$TopPlayerDetailDestination/${player.profile.accountId}")
                },
                text = player.profile.personaName ?: "Unknown name"
            )
        }
    }
}









