package com.codingwithmitch.dotainfo.presentation.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun DotaInfoBottomNavigation(
    navController: NavHostController
){
    val navItems = remember{ BottomNavItems.items }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    BottomNavigation(
        modifier = Modifier.fillMaxWidth()
    ) {
        navItems.forEach { navItem ->
            BottomNavigationItem(
                selected = currentRoute == navItem.route(),
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(navItem.route()) {
                        restoreState = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                label = { Text(text = stringResource(id = navItem.resourceId())) },
                icon = {
                    Icon(
                        imageVector = navItem.icon(),
                        contentDescription = stringResource(id = navItem.resourceId())
                    )
                }
            )
        }
    }
}















