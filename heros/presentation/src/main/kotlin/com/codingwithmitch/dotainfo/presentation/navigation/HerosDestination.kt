package com.codingwithmitch.dotainfo.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.codingwithmitch.dotainfo.heros.R
import com.codingwithmitch.navigation.BottomNavigationDestination

object HerosDestination: BottomNavigationDestination {
    override fun resourceId(): Int {
        return R.string.nav_heros
    }

    override fun icon(): ImageVector {
        return Icons.Filled.Person
    }

    override fun route(): String {
        return "heros"
    }
}

