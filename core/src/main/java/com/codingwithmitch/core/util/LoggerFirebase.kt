package com.codingwithmitch.core.util

class LoggerFirebase(
    private val tag: String,
    private val firebaseInstance: String
): Logger {

    override fun log(message: String) {
        // production logging - Crashlytics or whatever you want to use
        // TODO - Log into Firebase
    }

}
