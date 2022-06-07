package io.shortcut.domain.di

import io.shortcut.domain.repositories.ComicsApiRepository
import io.shortcut.domain.repositories.ComicsDatabaseRepository

interface RepositoriesProvider {

    fun provideComicsApiRepository(): ComicsApiRepository

    fun provideComicDatabaseRepository(): ComicsDatabaseRepository
}