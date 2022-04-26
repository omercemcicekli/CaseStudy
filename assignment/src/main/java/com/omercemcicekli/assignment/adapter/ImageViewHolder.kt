package com.omercemcicekli.assignment.adapter

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.omercemcicekli.assignment.R
import com.omercemcicekli.assignment.data.ImageData
import com.omercemcicekli.assignment.extensions.load
import com.omercemcicekli.assignment.metrics.MetricManager.Companion.metricFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

internal class ImageViewHolder(view: View, private val scope: CoroutineScope): RecyclerView.ViewHolder(view) {

    private val ivImage = view.findViewById<AppCompatImageView>(R.id.iv_image)

    fun bind(imageData: ImageData) {
        ivImage.load(imageData.url) { timeElapsed -> scope.launch { metricFlow.emit(timeElapsed) } }
    }
}