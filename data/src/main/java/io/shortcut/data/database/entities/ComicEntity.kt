package io.shortcut.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.shortcut.data.database.utils.COMIC_ENTITY_TABLE_NAME

@Entity(tableName = COMIC_ENTITY_TABLE_NAME)
class ComicEntity(

    @PrimaryKey val comicNum: Long,
    val title: String,
    val safeTitle: String,
    val transcript: String?,
    val alt: String,
    val img: ByteArray,
    val month: String,
    val link: String?,
    val year: String,
    val news: String?,
    val day: String
)