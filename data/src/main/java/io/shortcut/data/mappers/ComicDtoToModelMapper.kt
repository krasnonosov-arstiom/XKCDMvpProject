package io.shortcut.data.mappers

import io.shortcut.data.dto.ComicDto
import io.shortcut.domain.models.ComicModel

class ComicDtoToModelMapper(dto: ComicDto) {

    val model by lazy {
        dto.run {
            ComicModel(
                comicNum,
                title,
                safeTitle,
                nullIfEmpty(transcript),
                alt,
                img,
                month,
                link,
                year,
                nullIfEmpty(news),
                day
            )
        }
    }

    private fun nullIfEmpty(value: String): String? = value.ifEmpty { null }
}