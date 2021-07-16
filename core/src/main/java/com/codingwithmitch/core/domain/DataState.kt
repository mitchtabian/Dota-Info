package com.codingwithmitch.core.domain

sealed class DataState<T> {

    data class Response<T>(
        val uiComponent: UIComponent
    ): DataState<T>()

    data class Data<T>(
        val data: T? = null
    ): DataState<T>()

    data class Loading<T>(
        val state: ProgressBarState = ProgressBarState.Idle
    ): DataState<T>()
}