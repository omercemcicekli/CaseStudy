package com.omercemcicekli.casestudy

import com.omercemcicekli.assignment.data.ImageData

object ImageDataGenerator {

    private val allData = listOf(
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image1-500kb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image2-500kb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image3-500kb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image4-500kb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image1-1mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image2-1mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image3-1mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image4-1mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image1-1_5mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image2-1_5mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image3-1_5mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image4-1_5mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image1-2mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image2-2mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image3-2mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image4-2mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image1-3mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image2-3mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image3-3mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image4-3mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image1-5mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image2-5mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image3-5mb.png"),
        ImageData(url = "https://db62cod6cnasq.cloudfront.net/user-media/0/image4-5mb.png")
    )

    fun getTestData() = allData.subList(0, (5..24).random())
}