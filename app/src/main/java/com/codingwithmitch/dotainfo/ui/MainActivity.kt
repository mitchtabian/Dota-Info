package com.codingwithmitch.dotainfo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import coil.ImageLoader
import com.codingwithmitch.dotainfo.ui.navigation.Screen
import com.codingwithmitch.dotainfo.ui.theme.DotaInfoTheme
import com.codingwithmitch.ui_herodetail.ui.HeroDetail
import com.codingwithmitch.ui_herodetail.ui.HeroDetailViewModel
import com.codingwithmitch.ui_herolist.HeroList
import com.codingwithmitch.ui_herolist.ui.HeroListViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DotaInfoTheme {
                val navController = rememberAnimatedNavController()
                BoxWithConstraints {
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = Screen.HeroList.route,
                        builder = {
                            addHeroList(
                                navController = navController,
                                imageLoader = imageLoader,
                                width = constraints.maxWidth / 2,
                            )
                            addHeroDetail(
                                imageLoader = imageLoader,
                                width = constraints.maxWidth / 2,
                            )
                        }
                    )
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
fun NavGraphBuilder.addHeroList(
    navController: NavController,
    imageLoader: ImageLoader,
    width: Int,
) {
    composable(
        route = Screen.HeroList.route,
        exitTransition = {_, _ ->
            slideOutHorizontally(
                targetOffsetX = { -width },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(300))
        },
        popEnterTransition = { initial, _ ->
            slideInHorizontally(
                initialOffsetX = { -width },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(300))
        },
    ){
        val viewModel: HeroListViewModel = hiltViewModel()
        HeroList(
            state = viewModel.state.value,
            events = viewModel::onTriggerEvent,
            imageLoader = imageLoader,
            navigateToDetailScreen = { heroId ->
                navController.navigate("${Screen.HeroDetail.route}/$heroId")
            },
        )
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addHeroDetail(
    imageLoader: ImageLoader,
    width: Int,
) {
    composable(
        route = Screen.HeroDetail.route + "/{heroId}",
        arguments = Screen.HeroDetail.arguments,
        enterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = { width },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(300))
        },
        popExitTransition = { _, target ->
            slideOutHorizontally(
                targetOffsetX = { width },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(300))
        },

    ){
        val viewModel: HeroDetailViewModel = hiltViewModel()
        HeroDetail(
            state = viewModel.state.value,
            imageLoader = imageLoader,
        )
    }
}















