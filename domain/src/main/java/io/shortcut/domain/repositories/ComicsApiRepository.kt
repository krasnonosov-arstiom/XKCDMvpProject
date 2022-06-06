package io.shortcut.domain.repositories

import io.shortcut.domain.models.ComicModel

interface ComicsApiRepository {

    suspend fun getTheLastComic(): ComicModel

    suspend fun getComicWithNumberOf(comicNumber: Long): ComicModel
}