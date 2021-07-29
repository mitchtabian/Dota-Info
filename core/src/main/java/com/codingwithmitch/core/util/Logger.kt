package com.codingwithmitch.core.util

class Logger(
    private val tag: String,
    private val isDebug: Boolean = true,
) {
    fun log(msg: String){
        if (!isDebug) {
            // production logging - Crashlytics or whatever you want to use
        }
        else{
            printLogD(tag, msg)
        }
    }

    companion object Factory{
        fun buildDebug(className: String,): Logger{
            return Logger(
                tag = className,
                isDebug = true,
            )
        }
        fun buildRelease(className: String,): Logger{
            return Logger(
                tag = className,
                isDebug = false,
            )
        }
    }
}

fun printLogD(tag: String?, message: String ) {
    println("$tag: $message")
}