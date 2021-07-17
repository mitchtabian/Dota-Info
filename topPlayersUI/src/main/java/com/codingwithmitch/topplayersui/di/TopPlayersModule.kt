package com.codingwithmitch.topplayersui.di

import com.codingwithmitch.core.datasource.network.KtorClientFactory
import com.codingwithmitch.topplayerinteractors.GetPlayers
import com.codingwithmitch.topplayerservice.TopPlayerService
import com.codingwithmitch.topplayerservice.TopPlayerServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TopPlayersModule {

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return KtorClientFactory().build()
    }

    @Singleton
    @Provides
    fun provideTopPlayerService(
        httpClient: HttpClient,
    ): TopPlayerService {
        return TopPlayerServiceImpl(
            httpClient = httpClient,
        )
    }

    @Singleton
    @Provides
    fun provideGetPlayers(
        service: TopPlayerService
    ): GetPlayers {
        return GetPlayers(service)
    }

}