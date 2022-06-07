package io.shortcut.data.repositories_impl

import io.shortcut.data.api.XKCDApiService
import io.shortcut.data.mappers.ComicDtoToModelMapper
import io.shortcut.domain.models.ComicModel
import io.shortcut.domain.repositories.ComicsApiRepository
import javax.inject.Inject

class ComicsApiRepositoryImpl @Inject constructor(
    private val apiService: XKCDApiService
): ComicsApiRepository {

    override suspend fun getTheLastComic(): ComicModel {
        return ComicDtoToModelMapper(apiService.getTheLastComic()).model
    }

    override suspend fun getComicWithNumberOf(comicNumber: Long): ComicModel {
        return ComicDtoToModelMapper(apiService.getComicWithNumber(comicNumber)).model
    }
}