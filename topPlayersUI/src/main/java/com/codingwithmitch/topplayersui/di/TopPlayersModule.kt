package com.codingwithmitch.topplayersui.di

import com.codingwithmitch.topplayerinteractors.GetPlayers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TopPlayersModule {

    @Singleton
    @Provides
    fun provideGetPlayers(): GetPlayers {
        return GetPlayers.build()
    }

}