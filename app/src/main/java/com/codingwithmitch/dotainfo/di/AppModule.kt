package com.codingwithmitch.dotainfo.di

import com.codingwithmitch.core.util.Logger
import com.codingwithmitch.core.util.factory.LoggerDebugFactory
import com.codingwithmitch.core.util.factory.LoggerFactory
import com.codingwithmitch.core.util.factory.LoggerFirebaseFactory
import com.codingwithmitch.dotainfo.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLoggerFactory(): LoggerFactory {
        return if (BuildConfig.DEBUG) {
            LoggerDebugFactory()
        } else {
            LoggerFirebaseFactory()
        }
    }
}