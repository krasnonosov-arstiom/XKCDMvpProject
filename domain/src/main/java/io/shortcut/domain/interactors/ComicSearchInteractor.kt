package io.shortcut.domain.interactors

import io.shortcut.domain.models.ComicModel

interface ComicSearchInteractor {

    suspend fun getTheLastComic(): ComicModel

    suspend fun getComicWithNumberOf(comicNumber: Long): ComicModel

    suspend fun getRandomComic(): ComicModel

    suspend fun saveComicToFavourites(model: ComicModel)
}