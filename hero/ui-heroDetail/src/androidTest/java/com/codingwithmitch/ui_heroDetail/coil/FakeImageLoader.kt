package com.codingwithmitch.ui_heroDetail.coil

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import coil.ImageLoader
import coil.bitmap.BitmapPool
import coil.decode.DataSource
import coil.memory.MemoryCache
import coil.request.*

class FakeImageLoader {
    companion object Factory {
        fun build(context: Context): ImageLoader {
            return object : ImageLoader {

                private val disposable = object : Disposable {
                    override val isDisposed get() = true
                    override fun dispose() {}
                    override suspend fun await() {}
                }

                override val defaults = DefaultRequestOptions()

                // Optionally, you can add a custom fake memory cache implementation.
                override val memoryCache get() = throw UnsupportedOperationException()

                override val bitmapPool = BitmapPool(0)

                override fun enqueue(request: ImageRequest): Disposable {
                    // Always call onStart before onSuccess.
                    request.target?.onStart(placeholder = ColorDrawable(Color.BLACK))
                    request.target?.onSuccess(result = ColorDrawable(Color.BLACK))
                    return disposable
                }

                override suspend fun execute(request: ImageRequest): ImageResult {
                    return SuccessResult(
                        drawable = ColorDrawable(Color.BLACK),
                        request = request,
                        metadata = ImageResult.Metadata(
                            memoryCacheKey = MemoryCache.Key(""),
                            isSampled = false,
                            dataSource = DataSource.MEMORY_CACHE,
                            isPlaceholderMemoryCacheKeyPresent = false
                        )
                    )
                }

                override fun shutdown() {}

                override fun newBuilder() = ImageLoader.Builder(context)
            }
        }
    }
}