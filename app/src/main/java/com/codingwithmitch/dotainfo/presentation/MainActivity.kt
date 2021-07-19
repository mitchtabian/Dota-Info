package com.codingwithmitch.dotainfo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codingwithmitch.dotainfo.presentation.navigation.DotaInfoBottomNavigation
import com.codingwithmitch.dotainfo.presentation.theme.DotaInfoTheme
import com.codingwithmitch.herosui.Heros
import com.codingwithmitch.herosui.navigation.HerosDestination
import com.codingwithmitch.topplayersdetailui.navigation.TopPlayerDetailDestination
import com.codingwithmitch.topplayersui.presentation.TopPlayers
import com.codingwithmitch.topplayersui.presentation.TopPlayersViewModel
import com.codingwithmitch.topplayersui.navigation.TopPlayersDestination
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
                            addTopPlayers(navController)
                            addHeros()
                        }
                    )
                }
            }
        }
    }
}

private fun NavGraphBuilder.addTopPlayers(
    navController: NavController,
) {
    composable(TopPlayersDestination.route()){
        val viewModel: TopPlayersViewModel = hiltViewModel()
        TopPlayers(
            state = viewModel.state.value,
            events = viewModel::onTriggerEvent,
            navigateToDetailScreen = { accountId ->
                navController.navigate("$TopPlayerDetailDestination/$accountId")
            }
        )
    }
}

private fun NavGraphBuilder.addHeros() {
    composable(HerosDestination.route()){
        Heros()
    }
}














