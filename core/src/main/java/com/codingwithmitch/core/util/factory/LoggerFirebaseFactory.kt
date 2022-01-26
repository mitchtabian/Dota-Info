package com.codingwithmitch.core.util.factory

import com.codingwithmitch.core.util.Logger
import com.codingwithmitch.core.util.LoggerDebug
import com.codingwithmitch.core.util.LoggerFirebase

class LoggerFirebaseFactory: LoggerFactory {

    override fun createLogger(tag: String): Logger {
        return LoggerFirebase(tag, firebaseInstance = "production_i001")
    }

}