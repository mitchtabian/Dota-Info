package com.codingwithmitch.dotainfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import com.codingwithmitch.dotainfo.herosPresentation.HeroScreen
import com.codingwithmitch.dotainfo.presentation.PlayerScreen
import com.codingwithmitch.dotainfo.ui.theme.DotaInfoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DotaInfoTheme {
                Column {
                    PlayerScreen()
                    HeroScreen()
                }
            }
        }
    }
}















