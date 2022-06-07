package io.shortcut.data.di

import dagger.Binds
import dagger.Module
import io.shortcut.data.repositories_impl.ComicsApiRepositoryImpl
import io.shortcut.data.repositories_impl.ComicsDatabaseRepositoryImpl
import io.shortcut.domain.repositories.ComicsApiRepository
import io.shortcut.domain.repositories.ComicsDatabaseRepository
import javax.inject.Singleton

@Module
interface RepositoriesModule {

    @Singleton
    @Binds
    fun provideComicsApiRepository(repository: ComicsApiRepositoryImpl): ComicsApiRepository

    @Singleton
    @Binds
    fun provideComicDatabaseRepository(repository: ComicsDatabaseRepositoryImpl): ComicsDatabaseRepository
}