package com.codingwithmitch.dotainfo.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector
import com.codingwithmitch.dotainfo.players.R
import com.codingwithmitch.navigation.BottomNavigationDestination

object TopPlayersDestination: BottomNavigationDestination {
    override fun resourceId(): Int {
        return R.string.nav_top_players
    }

    override fun icon(): ImageVector {
        return Icons.Filled.List
    }

    override fun route(): String {
        return "topPlayers"
    }
}

