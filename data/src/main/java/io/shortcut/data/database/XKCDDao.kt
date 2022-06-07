package io.shortcut.data.database

import androidx.room.*
import io.shortcut.data.database.entities.ComicEntity
import io.shortcut.data.database.utils.COMIC_ENTITY_TABLE_NAME

@Dao
interface XKCDDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addComicToFavourites(comicEntity: ComicEntity)

    @Delete
    suspend fun removeComicFromFavourites(comicEntity: ComicEntity)

    @Query("SELECT * FROM $COMIC_ENTITY_TABLE_NAME")
    suspend fun getAllComics(): List<ComicEntity>

    @Query("SELECT * FROM $COMIC_ENTITY_TABLE_NAME WHERE comicNum=:comicNum")
    suspend fun getComicWithNumber(comicNum: Long): ComicEntity
}