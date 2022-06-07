package io.shortcut.data.mappers

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import io.shortcut.data.database.entities.ComicEntity
import io.shortcut.domain.models.ComicModel
import java.io.ByteArrayOutputStream
import java.net.URL

class ComicModelToEntityMapper(model: ComicModel) {

    val entity by lazy {
        model.run {
            val url = URL(model.img)
            val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            val outputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            val imageByteArray = outputStream.toByteArray()
            bitmap.recycle()
            ComicEntity(
                comicNum,
                title,
                safeTitle,
                transcript,
                alt,
                imageByteArray,
                month, link, year, news, day
            )
        }
    }
}