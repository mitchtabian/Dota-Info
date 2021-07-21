package com.codingwithmitch.util

import androidx.compose.material.SnackbarDuration

fun Long.toSnackbarDuration(): SnackbarDuration {
    return when(this){
        com.codingwithmitch.core.domain.SnackbarDuration.INDEFINITE.value -> {
            SnackbarDuration.Indefinite
        }
        com.codingwithmitch.core.domain.SnackbarDuration.LONG.value -> {
            SnackbarDuration.Long
        }
        com.codingwithmitch.core.domain.SnackbarDuration.SHORT.value -> {
            SnackbarDuration.Short
        }
        else -> SnackbarDuration.Short
    }
}