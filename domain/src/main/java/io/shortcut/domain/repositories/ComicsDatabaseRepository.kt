package io.shortcut.domain.repositories

import io.shortcut.domain.models.ComicModel
import io.shortcut.domain.models.ComicModelDB

interface ComicsDatabaseRepository {

    suspend fun addComicToFavourites(comicModel: ComicModel)

    suspend fun removeComicFromFavourites(comicModelDB: ComicModelDB)

    suspend fun getAllComics(): List<ComicModelDB>

    suspend fun getComicWithNumber(comicNum: Long): ComicModelDB
}