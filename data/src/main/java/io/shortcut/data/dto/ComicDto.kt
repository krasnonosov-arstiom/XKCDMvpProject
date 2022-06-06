package io.shortcut.data.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ComicDto(

    @Expose
    @SerializedName("num")
    val comicNum: Long,

    @Expose
    @SerializedName("title")
    val title: String,

    @Expose
    @SerializedName("safeTitle")
    val safeTitle: String,

    @Expose
    @SerializedName("transcript")
    val transcript: String,

    @Expose
    @SerializedName("alt")
    val alt: String,

    @Expose
    @SerializedName("img")
    val img: String,

    @Expose
    @SerializedName("month")
    val month: String,

    @Expose
    @SerializedName("link")
    val link: String,

    @Expose
    @SerializedName("year")
    val year: String,

    @Expose
    @SerializedName("news")
    val news: String,

    @Expose
    @SerializedName("day")
    val day: String
)