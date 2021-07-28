package com.codingwithmitch.dotainfo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.codingwithmitch.dotainfo.ui.theme.DotaInfoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DotaInfoTheme {
                Text("Starting point")
            }
        }
    }
}















