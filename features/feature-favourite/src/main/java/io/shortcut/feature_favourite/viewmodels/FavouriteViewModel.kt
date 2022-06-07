package io.shortcut.feature_favourite.viewmodels

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.shortcut.core_feature.base.BaseViewModel
import io.shortcut.core_feature.di.AssistedViewModelFactory
import io.shortcut.domain.interactors.FavouriteComicsInteractor
import io.shortcut.domain.models.ComicModelDB

class FavouriteViewModel @AssistedInject constructor(
    @Assisted arguments: Bundle,
    private val interactor: FavouriteComicsInteractor
) : BaseViewModel() {

    private val _favouriteComicsLiveData = MutableLiveData<List<ComicModelDB>>()
    val favouriteComicsLiveData: LiveData<List<ComicModelDB>> = _favouriteComicsLiveData

    init {
        launchWithLoading {
            _favouriteComicsLiveData.value = interactor.getAllComics()
        }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<FavouriteViewModel> {

        override fun create(arguments: Bundle): FavouriteViewModel
    }
}