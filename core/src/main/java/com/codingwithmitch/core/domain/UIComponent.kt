package com.codingwithmitch.core.domain

sealed class UIComponent{

    data class Dialog(
        val title: String,
        val description: String,
    ): UIComponent()

    data class Toast(
        val text: String,
        val duration: ToastDuration
    ): UIComponent()

    data class SnackBar(
        val text: String,
        val duration: SnackbarDuration,
    ): UIComponent()
    
    data class None(
        val message: String,
    ): UIComponent()
}

sealed class SnackbarDuration(val value: Long){
    object INDEFINITE: SnackbarDuration(Long.MAX_VALUE)
    object LONG: SnackbarDuration(10000L)
    object SHORT: SnackbarDuration(4000L)
}

sealed class ToastDuration(val value: Long){

    object SHORT: ToastDuration(0)

    object LONG: ToastDuration(1)
}






