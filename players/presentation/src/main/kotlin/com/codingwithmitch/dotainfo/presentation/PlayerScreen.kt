package com.codingwithmitch.dotainfo.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.codingwithmitch.dotainfo.business.PlayerData

@Composable
fun PlayerScreen(){
    Text(PlayerData().name())
}