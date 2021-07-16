package com.codingwithmitch.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

interface BottomNavigationDestination: NavigationDestination {

    @StringRes
    fun resourceId(): Int

    fun icon(): ImageVector
}