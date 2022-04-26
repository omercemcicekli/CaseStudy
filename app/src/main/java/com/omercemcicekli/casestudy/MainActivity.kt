package com.omercemcicekli.casestudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.omercemcicekli.assignment.AssignmentView
import com.omercemcicekli.assignment.data.ImageData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view = findViewById<AssignmentView>(R.id.assignment_view)

        val imageData = listOf(
            ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image1-500kb.png"),
            ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image2-500kb.png"),
            ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image3-500kb.png"),
            ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image4-500kb.png"),
            ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image3-1mb.png"))

        view.setImageData(imageData)
    }
}