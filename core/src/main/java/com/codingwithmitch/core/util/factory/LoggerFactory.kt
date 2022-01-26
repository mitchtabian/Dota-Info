package com.codingwithmitch.core.util.factory

import com.codingwithmitch.core.util.Logger

interface LoggerFactory {

    fun createLogger(tag: String): Logger

}