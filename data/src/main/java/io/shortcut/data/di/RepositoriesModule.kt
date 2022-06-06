package io.shortcut.data.di

import dagger.Binds
import dagger.Module
import io.shortcut.data.repositories_impl.ComicsApiRepositoryImpl
import io.shortcut.domain.repositories.ComicsApiRepository
import javax.inject.Singleton

@Module
interface RepositoriesModule {

    @Singleton
    @Binds
    fun provideComicsApiRepository(repository: ComicsApiRepositoryImpl): ComicsApiRepository
}