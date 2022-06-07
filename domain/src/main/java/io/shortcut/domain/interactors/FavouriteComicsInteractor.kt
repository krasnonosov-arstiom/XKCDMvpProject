package io.shortcut.domain.interactors

import io.shortcut.domain.models.ComicModelDB

interface FavouriteComicsInteractor {

    suspend fun getAllComics(): List<ComicModelDB>
}