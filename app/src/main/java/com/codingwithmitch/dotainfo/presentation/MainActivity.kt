package com.codingwithmitch.dotainfo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codingwithmitch.dotainfo.presentation.navigation.Screen
import com.codingwithmitch.dotainfo.presentation.theme.DotaInfoTheme
import com.codingwithmitch.ui_herodetail.ui.HeroDetail
import com.codingwithmitch.ui_herodetail.ui.HeroDetailViewModel
import com.codingwithmitch.ui_herolist.ui.HeroList
import com.codingwithmitch.ui_herolist.ui.HeroListViewModel
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
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

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
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

@ExperimentalAnimationApi
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

@ExperimentalAnimationApi
@Composable
fun EnterAnimation(content: @Composable () -> Unit) {
    AnimatedVisibility(
        visible = true,
        enter = slideInVertically(
            initialOffsetY = { -40 }
        ) + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically() + shrinkVertically() + fadeOut(),
    ){
        content()
    }
}












