package io.shortcut.domain.di

import io.shortcut.domain.interactors.ComicSearchInteractor
import io.shortcut.domain.interactors.FavouriteComicsInteractor

interface InteractorsProvider {

    fun provideComicSearchInteractor(): ComicSearchInteractor

    fun provideFavouriteComicsInteractor(): FavouriteComicsInteractor
}