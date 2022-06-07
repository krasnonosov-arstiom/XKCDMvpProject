package io.shortcut.data.mappers

import android.graphics.BitmapFactory
import io.shortcut.data.database.entities.ComicEntity
import io.shortcut.domain.models.ComicModelDB

class ComicEntityToModelDBMapper(entity: ComicEntity) {

    val model by lazy {
        entity.run {
            val bitmap =
                BitmapFactory.decodeByteArray(entity.img, 0, entity.img.size)
            ComicModelDB(
                comicNum,
                title,
                safeTitle,
                transcript,
                alt,
                bitmap,
                img,
                month,
                link,
                year,
                news,
                day
            )
        }
    }
}