package com.codingwithmitch.dotainfo.di

import android.app.Application
import coil.ImageLoader
import com.codingwithmitch.dotainfo.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CoilModule {

    /**
     * Coil docs say: Coil performs best when you create a single ImageLoader and share it throughout your app. This is because each ImageLoader has its own memory cache, bitmap pool, and network observer.
     * For testing: https://coil-kt.github.io/coil/image_loaders/#testing
     */
    @Provides
    @Singleton
    fun provideImageLoader(app: Application): ImageLoader{
        return ImageLoader.Builder(app)
            .error(R.drawable.error_image)
            .placeholder(R.drawable.white_background)
            .availableMemoryPercentage(0.25) // Don't know what is recommended?
            .crossfade(true)
            .build()
    }
}














