package io.shortcut.domain.di

import dagger.Binds
import dagger.Module
import io.shortcut.domain.interactors.ComicSearchInteractor
import io.shortcut.domain.interactors.FavouriteComicsInteractor
import io.shortcut.domain.interactors_impl.ComicSearchInteractorImpl
import io.shortcut.domain.interactors_impl.FavouriteComicsInteractorImpl

@Module
interface InteractorsModule {

    @Binds
    fun provideComicSearchInteractor(interactor: ComicSearchInteractorImpl): ComicSearchInteractor

    @Binds
    fun provideFavouriteComicsInteractor(interactor: FavouriteComicsInteractorImpl): FavouriteComicsInteractor
}