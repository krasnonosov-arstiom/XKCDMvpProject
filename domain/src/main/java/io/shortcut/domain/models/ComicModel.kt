package io.shortcut.domain.models

class ComicModel(

    val comicNum: Long,
    val title: String,
    val safeTitle: String,
    val transcript: String?,
    val alt: String,
    val img: String,
    val month: String,
    val link: String?,
    val year: String,
    val news: String?,
    val day: String
)