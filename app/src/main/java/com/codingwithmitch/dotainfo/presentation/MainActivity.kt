package com.codingwithmitch.dotainfo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codingwithmitch.dotainfo.presentation.navigation.Screen
import com.codingwithmitch.dotainfo.presentation.theme.DotaInfoTheme
import com.codingwithmitch.ui_herodetail.HeroDetail
import com.codingwithmitch.ui_herodetail.HeroDetailViewModel
import com.codingwithmitch.ui_herolist.HeroList
import com.codingwithmitch.ui_herolist.HeroListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DotaInfoTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.HeroList.route,
                    builder = {
                        addHeroList(navController = navController)
                        addHeroDetail()
                    }
                )
            }
        }
    }
}

private fun NavGraphBuilder.addHeroList(navController: NavController) {
    composable(
        route = Screen.HeroList.route,
    ){
        val viewModel: HeroListViewModel = hiltViewModel()
        HeroList(
            state = viewModel.state.value,
            events = viewModel::onTriggerEvent,
            navigateToDetailScreen = { heroId ->
                navController.navigate("${Screen.HeroDetail.route}/$heroId")
            }
        )
    }
}

private fun NavGraphBuilder.addHeroDetail() {
    composable(
        route = Screen.HeroDetail.route + "/{heroId}",
        arguments = Screen.HeroDetail.arguments,
    ){
        val viewModel: HeroDetailViewModel = hiltViewModel()
        HeroDetail(
            state = viewModel.state.value,
            events = viewModel::onTriggerEvent,
        )
    }
}















