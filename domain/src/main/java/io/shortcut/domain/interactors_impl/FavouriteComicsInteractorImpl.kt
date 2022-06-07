package io.shortcut.domain.interactors_impl

import io.shortcut.domain.interactors.FavouriteComicsInteractor
import io.shortcut.domain.models.ComicModelDB
import io.shortcut.domain.repositories.ComicsDatabaseRepository
import javax.inject.Inject

class FavouriteComicsInteractorImpl @Inject constructor(private val databaseRepository: ComicsDatabaseRepository) :
    FavouriteComicsInteractor {

    override suspend fun getAllComics(): List<ComicModelDB> {
        return databaseRepository.getAllComics()
    }
}