package com.codingwithmitch.core.domain

sealed class UIComponent{

    data class Dialog(
        val title: String,
        val description: String,
    ): UIComponent()

    data class Toast(
        val text: String,
        val duration: Int
    ): UIComponent()

    data class SnackBar(
        val text: String,
        val duration: Int,
    ): UIComponent()
    
    data class None(
        val message: String,
    ): UIComponent()
}








