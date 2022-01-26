package com.codingwithmitch.core.util.factory

import com.codingwithmitch.core.util.Logger
import com.codingwithmitch.core.util.LoggerDebug

class LoggerDebugFactory: LoggerFactory {

    override fun createLogger(tag: String): Logger {
        return LoggerDebug(tag)
    }

}