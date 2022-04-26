package com.omercemcicekli.assignment.metrics

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

internal class MetricManager(private val scope: CoroutineScope) {

    companion object {
        val metricFlow = MutableSharedFlow<Long>()
    }

    /* Basically listen for the view holder image loading time data, and send it for every 10
    * (You could send it everytime we collect but that is not optimal and will use tons of data)
    */
    fun listenForMetricData() {
        scope.launch {
            val timeData = mutableListOf<Long>()
            metricFlow.collect {

                timeData.add(it)

                if(timeData.size % 10 == 0) {
                    sendMetricsToService()
                    timeData.clear()
                }
            }
        }
    }

    private fun sendMetricsToService() {

    }
}