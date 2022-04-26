package com.omercemcicekli.assignment

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.omercemcicekli.assignment.adapter.ImageAdapter
import com.omercemcicekli.assignment.constants.Constants.DEFAULT_SKIP_DELAY
import com.omercemcicekli.assignment.data.ImageData
import com.omercemcicekli.assignment.extensions.executeInMain
import com.omercemcicekli.assignment.metrics.MetricManager
import kotlinx.coroutines.*

class AssignmentView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private val parentJob = Job()
    private val scope = CoroutineScope(Dispatchers.IO + parentJob)

    private val recyclerView: RecyclerView = RecyclerView(context)
    private val imageAdapter = ImageAdapter(scope = scope)

    private val metricManager = MetricManager(scope)

    private val automaticSkipDelay: Int?

    init {
        automaticSkipDelay = getAutomaticSkipDelay(attrs)

        recyclerView.apply {
            id = View.generateViewId()
            this@AssignmentView.addView(this)
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            PagerSnapHelper().attachToRecyclerView(this@apply)
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = imageAdapter
        }

        metricManager.listenForMetricData()
    }

    fun setImageData(imageData: List<ImageData>) {
        require(imageData.isNotEmpty()) { "Image list cannot be empty." }

        imageAdapter.populateWithNewData(imageData)

        automaticSkipDelay?.let {
            require(it > 0) { "Delay can't be 0 or negative." }

            scope.launch {
                var index = 1

                while (true) {
                    delay(it.toLong())

                    executeInMain { recyclerView.smoothScrollToPosition(index) }

                    index++

                    if(index == imageData.size)
                        break
                }
            }
        }
    }

    private fun getAutomaticSkipDelay(attrs: AttributeSet): Int? = context.theme.obtainStyledAttributes(attrs, R.styleable.AssignmentView, 0, 0).run {
        try {
            val isSkipEnabled = getBoolean(R.styleable.AssignmentView_automaticSkip, false)

            if(isSkipEnabled)
                getInteger(R.styleable.AssignmentView_automaticSkipDelay, DEFAULT_SKIP_DELAY)
            else
                null
        }

        finally { recycle() }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        scope.cancel()
    }
}