package io.shortcut.domain.interactors_impl

import io.shortcut.domain.interactors.ComicSearchInteractor
import io.shortcut.domain.models.ComicModel
import io.shortcut.domain.repositories.ComicsApiRepository
import javax.inject.Inject

class ComicSearchInteractorImpl @Inject constructor(
    private val comicApiRepository: ComicsApiRepository
) : ComicSearchInteractor {

    override suspend fun getTheLastComic(): ComicModel {
        return comicApiRepository.getTheLastComic()
    }

    override suspend fun getComicWithNumberOf(comicNumber: Long): ComicModel {
        return comicApiRepository.getComicWithNumberOf(comicNumber)
    }

    override suspend fun getRandomComic(): ComicModel {
        val lastComicModel = comicApiRepository.getTheLastComic()
        val randomNumber = (0..lastComicModel.comicNum).random()
        return getComicWithNumberOf(randomNumber)
    }
}