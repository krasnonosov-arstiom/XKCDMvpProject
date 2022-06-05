package io.shortcut.data.api

import io.shortcut.data.dto.ComicDto
import retrofit2.http.GET
import retrofit2.http.Path

interface XKCDApiService {

    @GET("info.0.json")
    suspend fun getTheLastComic(): ComicDto

    @GET("{comicNum}/info.0.json")
    suspend fun getComicWithNumberOf(@Path("comicNum") comicNum: Long): ComicDto
}