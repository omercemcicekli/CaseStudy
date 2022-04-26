package com.omercemcicekli.assignment.metrics.service

import com.omercemcicekli.assignment.metrics.MetricData
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

internal interface MetricService {
    @POST("post")
    suspend fun sendMetricData(@Body metricData: List<MetricData>): Response<ResponseBody>
}