package io.shortcut.domain.di

import io.shortcut.domain.repositories.ComicsApiRepository

interface RepositoriesProvider {

    fun provideComicsApiRepository(): ComicsApiRepository
}