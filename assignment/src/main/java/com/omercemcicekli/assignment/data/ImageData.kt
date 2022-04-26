package com.omercemcicekli.assignment.data

import java.util.*

data class ImageData(
    val uuid: String = UUID.randomUUID().toString(),
    val url: String
)