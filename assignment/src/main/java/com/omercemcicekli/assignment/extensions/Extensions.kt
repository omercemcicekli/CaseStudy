package com.omercemcicekli.assignment.extensions

import android.widget.ImageView
import coil.load
import coil.request.CachePolicy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// Executes given block in the main thread
internal suspend fun <T> executeInMain(block: suspend CoroutineScope.() -> T) {
    withContext(Dispatchers.Main, block)
}

internal fun ImageView.load(url: String, timeElapsedBlock: (Long) -> Unit) {

    var timeElapsed: Long = 0L

    load(url) {
        crossfade(true)
        memoryCacheKey(url)
        diskCachePolicy(CachePolicy.ENABLED)
        memoryCachePolicy(CachePolicy.ENABLED)
        listener(onStart = { timeElapsed = System.currentTimeMillis() },
            onSuccess = { _, _ ->
                timeElapsed = System.currentTimeMillis() - timeElapsed
                timeElapsedBlock.invoke(timeElapsed)
            },
            onError = { _, _ ->
                timeElapsed = System.currentTimeMillis() - timeElapsed
                timeElapsedBlock.invoke(timeElapsed)
            })
    }
}