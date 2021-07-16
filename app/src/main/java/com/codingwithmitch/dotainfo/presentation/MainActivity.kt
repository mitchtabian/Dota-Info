package com.codingwithmitch.dotainfo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codingwithmitch.dotainfo.presentation.navigation.DotaInfoBottomNavigation
import com.codingwithmitch.dotainfo.presentation.navigation.HerosDestination
import com.codingwithmitch.dotainfo.presentation.navigation.TopPlayersDestination
import com.codingwithmitch.dotainfo.presentation.theme.DotaInfoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DotaInfoTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        DotaInfoBottomNavigation(navController)
                    }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = TopPlayersDestination.route(),
                        builder = {
                            addTopPlayers()
                            addHeros()
                        }
                    )
                }
            }
        }
    }
}

private fun NavGraphBuilder.addTopPlayers() {
    composable(TopPlayersDestination.route()){
        TopPlayers()
    }
}

private fun NavGraphBuilder.addHeros() {
    composable(HerosDestination.route()){
        Heros()
    }
}














