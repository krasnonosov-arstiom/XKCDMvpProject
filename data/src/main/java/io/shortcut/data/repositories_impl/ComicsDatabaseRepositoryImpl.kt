package io.shortcut.data.repositories_impl

import io.shortcut.data.database.XKCDDao
import io.shortcut.data.mappers.ComicEntityToModelDBMapper
import io.shortcut.data.mappers.ComicModelDBToEntityMapper
import io.shortcut.data.mappers.ComicModelToEntityMapper
import io.shortcut.domain.models.ComicModel
import io.shortcut.domain.models.ComicModelDB
import io.shortcut.domain.repositories.ComicsDatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ComicsDatabaseRepositoryImpl @Inject constructor(private val dao: XKCDDao) :
    ComicsDatabaseRepository {

    override suspend fun addComicToFavourites(comicModel: ComicModel) {
        withContext(Dispatchers.IO) {
            dao.addComicToFavourites(ComicModelToEntityMapper(comicModel).entity)
        }
    }

    override suspend fun removeComicFromFavourites(comicModelDB: ComicModelDB) {
        withContext(Dispatchers.IO) {
            dao.removeComicFromFavourites(ComicModelDBToEntityMapper(comicModelDB).entity)
        }
    }

    override suspend fun getAllComics(): List<ComicModelDB> {
        return withContext(Dispatchers.IO) {
            dao.getAllComics().map { ComicEntityToModelDBMapper(it).model }
        }
    }

    override suspend fun getComicWithNumber(comicNum: Long): ComicModelDB {
        return withContext(Dispatchers.IO) {
            ComicEntityToModelDBMapper(dao.getComicWithNumber(comicNum)).model
        }
    }
}