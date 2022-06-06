package io.shortcut.data.mappers

import io.shortcut.data.dto.ComicDto
import io.shortcut.domain.models.ComicModel

class ComicModelMapper(dto: ComicDto) {

    val model by lazy {
        dto.run {
            ComicModel(
                comicNum, title, safeTitle, transcript, alt, img, month, link, year, news, day
            )
        }
    }
}