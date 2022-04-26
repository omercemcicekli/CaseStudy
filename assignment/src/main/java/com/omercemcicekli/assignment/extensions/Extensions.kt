package com.omercemcicekli.assignment.extensions

import android.widget.ImageView
import coil.load
import coil.request.CachePolicy
import com.omercemcicekli.assignment.data.ImageData
import com.omercemcicekli.assignment.metrics.MetricData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// Executes given block in the main thread
internal suspend fun <T> executeInMain(block: suspend CoroutineScope.() -> T) {
    withContext(Dispatchers.Main, block)
}

internal fun ImageView.load(imageData: ImageData, metricDataBlock: (MetricData) -> Unit) {

    var timeElapsed = 0L

    load(imageData.url) {
        crossfade(true)
        memoryCacheKey(imageData.url)
        diskCacheKey(imageData.url)
        diskCachePolicy(CachePolicy.ENABLED)
        memoryCachePolicy(CachePolicy.ENABLED)
        listener(onStart = { timeElapsed = System.currentTimeMillis() },
            onSuccess = { _, _ ->
                timeElapsed = System.currentTimeMillis() - timeElapsed
                metricDataBlock.invoke(MetricData(imageData.uuid, timeElapsed, true))
            },
            onError = { _, _ ->
                timeElapsed = System.currentTimeMillis() - timeElapsed
                metricDataBlock.invoke(MetricData(imageData.uuid, timeElapsed, false))
            })
    }
}