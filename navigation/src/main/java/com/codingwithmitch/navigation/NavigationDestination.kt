package com.codingwithmitch.navigation

import androidx.navigation.compose.NamedNavArgument


fun interface NavigationDestination {

    fun route(): String

    val arguments: List<NamedNavArgument>
        get() = emptyList()
}