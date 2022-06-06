package io.shortcut.domain.di

import dagger.Binds
import dagger.Module
import io.shortcut.domain.interactors.ComicSearchInteractor
import io.shortcut.domain.interactors_impl.ComicSearchInteractorImpl

@Module
interface InteractorsModule {

    @Binds
    fun provideComicSearchInteractor(interactor: ComicSearchInteractorImpl): ComicSearchInteractor
}