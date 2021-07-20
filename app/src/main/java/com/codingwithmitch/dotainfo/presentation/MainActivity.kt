package com.codingwithmitch.dotainfo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codingwithmitch.dotainfo.presentation.theme.DotaInfoTheme
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
                Scaffold {
                    NavHost(
                        navController = navController,
                        startDestination = "heroList",
                        builder = {
                            addHeroList()
                        }
                    )
                }
            }
        }
    }
}

private fun NavGraphBuilder.addHeroList() {
    composable("heroList"){
        val viewModel: HeroListViewModel = hiltViewModel()
        HeroList()
    }
}















