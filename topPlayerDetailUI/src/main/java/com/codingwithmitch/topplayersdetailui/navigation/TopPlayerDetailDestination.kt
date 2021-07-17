package com.codingwithmitch.topplayersdetailui.navigation

import androidx.navigation.NavType
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.navArgument
import com.codingwithmitch.navigation.NavigationDestination

object TopPlayerDetailDestination: NavigationDestination {
    override fun route(): String {
        return "playerDetail/$ACCOUNT_ID_PARAM"
    }

    override val arguments: List<NamedNavArgument>
        get() = listOf(navArgument(ACCOUNT_ID_PARAM) { type = NavType.IntType })

    const val ACCOUNT_ID_PARAM = "accountId"
}

