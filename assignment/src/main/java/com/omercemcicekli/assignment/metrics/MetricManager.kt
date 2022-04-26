package com.omercemcicekli.assignment.metrics

import android.util.Log
import com.omercemcicekli.assignment.constants.Constants.TAG
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

internal class MetricManager(private val scope: CoroutineScope) {

    companion object {
        val metricDataFlow = MutableSharedFlow<MetricData>()
    }

    /* Basically listen for the view holder image loading time data, and send it for every 10
    * (You could send it everytime we collect but that is not optimal and will use tons of data)
    */
    fun listenForMetricData() {
        scope.launch {
            val metricData = mutableListOf<MetricData>()

            metricDataFlow.collect {

                Log.d(TAG, "Metric data for image loading: $it")

                metricData.add(it)

                if(isPowerOfTen(metricData)) {
                    Log.d(TAG, "Sending metric data to service: $metricData")
                    sendMetricsToService()
                    metricData.clear()
                }
            }
        }
    }

    private fun isPowerOfTen(metricData: List<MetricData>) = metricData.size % 10 == 0

    private fun sendMetricsToService() {

    }
}