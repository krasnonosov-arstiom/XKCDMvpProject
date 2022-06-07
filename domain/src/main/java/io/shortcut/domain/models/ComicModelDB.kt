package io.shortcut.domain.models

import android.graphics.Bitmap

class ComicModelDB(
    val comicNum: Long,
    val title: String,
    val safeTitle: String,
    val transcript: String?,
    val alt: String,
    val img: Bitmap,
    val imgByteArray: ByteArray,
    val month: String,
    val link: String?,
    val year: String,
    val news: String?,
    val day: String
)