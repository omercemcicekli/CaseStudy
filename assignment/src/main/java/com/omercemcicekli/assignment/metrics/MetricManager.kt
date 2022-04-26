package com.omercemcicekli.assignment.metrics

import android.util.Log
import com.omercemcicekli.assignment.constants.Constants.METRIC_SERVICE_BASE_URL
import com.omercemcicekli.assignment.constants.Constants.TAG
import com.omercemcicekli.assignment.metrics.service.MetricService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class MetricManager(private val scope: CoroutineScope) {

    companion object {
        val metricDataFlow = MutableSharedFlow<MetricData>()
    }

    private val metricService by lazy {
        Retrofit.Builder()
            .baseUrl(METRIC_SERVICE_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MetricService::class.java)
    }

    /* Basically listen for the view holder image loading time data, and send it for every 3
    * (You could send it everytime we collect but that is not optimal and will use tons of data)
    */
    fun listenForMetricData() {
        scope.launch {
            val metricData = mutableListOf<MetricData>()

            metricDataFlow.collect {

                Log.d(TAG, "Metric data for image loading: $it")

                metricData.add(it)

                if(isPowerOfThree(metricData)) {
                    sendMetricsToService(metricData)
                    metricData.clear()
                }
            }
        }
    }

    private fun isPowerOfThree(metricData: List<MetricData>) = metricData.size % 3 == 0

    private suspend fun sendMetricsToService(metricData: List<MetricData>) {
        Log.d(TAG, "Sending metric data to service: $metricData")

        runCatching { Log.d(TAG, "Metric service response: ${metricService.sendMetricData(metricData)}") }
            .getOrElse { Log.d(TAG, "Metric service Error. Cause: $it") }
    }
}