package io.shortcut.data.mappers

import io.shortcut.data.database.entities.ComicEntity
import io.shortcut.domain.models.ComicModelDB

class ComicModelDBToEntityMapper(model: ComicModelDB) {

    val entity by lazy {
        model.run {
            ComicEntity(
                comicNum,
                title,
                safeTitle,
                transcript,
                alt,
                imgByteArray,
                month,
                link,
                year,
                news,
                day
            )
        }
    }
}