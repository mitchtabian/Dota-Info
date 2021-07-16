package com.codingwithmitch.dotainfo.business

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun PlayerScreen(){
    Text(PlayerData().name())
}