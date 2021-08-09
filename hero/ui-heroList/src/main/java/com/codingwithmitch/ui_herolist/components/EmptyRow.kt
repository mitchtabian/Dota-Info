package com.codingwithmitch.ui_herolist.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EmptyRow(){
    Row(
        modifier = Modifier
            .padding(bottom = 0.dp)
            .fillMaxWidth()
        ,
    ){
        Text(
            text = "",
            style = MaterialTheme.typography.h4,
        )
    }
}