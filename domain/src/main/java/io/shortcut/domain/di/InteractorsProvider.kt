package io.shortcut.domain.di

import io.shortcut.domain.interactors.ComicSearchInteractor

interface InteractorsProvider {

    fun provideComicSearchInteractor(): ComicSearchInteractor
}