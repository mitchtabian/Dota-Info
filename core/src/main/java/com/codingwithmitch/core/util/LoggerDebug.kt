package com.codingwithmitch.core.util

class LoggerDebug(
    private val tag: String
): Logger {

    override fun log(message: String) {
        println("$tag: $message")
    }

}
