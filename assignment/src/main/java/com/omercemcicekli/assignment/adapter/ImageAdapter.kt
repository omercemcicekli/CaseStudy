package com.omercemcicekli.assignment.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omercemcicekli.assignment.R
import com.omercemcicekli.assignment.data.ImageData
import kotlinx.coroutines.CoroutineScope

internal class ImageAdapter(private var imageData: List<ImageData> = emptyList(), private val scope: CoroutineScope): RecyclerView.Adapter<ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.image_view_holder, parent, false), scope)

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) = holder.bind(imageData[position])

    override fun getItemCount() = imageData.size

    @SuppressLint("NotifyDataSetChanged")
    fun populateWithNewData(imageData: List<ImageData>) {
        this.imageData = imageData
        notifyDataSetChanged()
    }
}