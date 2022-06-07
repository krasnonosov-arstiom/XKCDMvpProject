package io.shortcut.feature_search.viewmodels

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.shortcut.core_feature.base.BaseViewModel
import io.shortcut.core_feature.di.AssistedViewModelFactory
import io.shortcut.domain.interactors.ComicSearchInteractor
import io.shortcut.domain.models.ComicModel

class SearchComicViewModel @AssistedInject constructor(
    @Assisted arguments: Bundle,
    private val interactor: ComicSearchInteractor
) : BaseViewModel() {

    private val _comicModelLiveData = MutableLiveData<ComicModel>()
    val comicModelLiveData: LiveData<ComicModel> = _comicModelLiveData

    private var currentComicNumber = 0L

    init {
        getNewComicWithSetCurrentNumber { interactor.getTheLastComic() }
    }

    fun getComicWithNumber(comicNumber: Long) {
        getNewComicWithSetCurrentNumber { interactor.getComicWithNumberOf(comicNumber) }
    }

    fun getNextComic() {
        getNewComicWithSetCurrentNumber { interactor.getComicWithNumberOf(currentComicNumber + 1) }
    }

    fun getPreviousComic() {
        getNewComicWithSetCurrentNumber { interactor.getComicWithNumberOf(currentComicNumber - 1) }
    }

    fun getRandomComic() {
        getNewComicWithSetCurrentNumber { interactor.getRandomComic() }
    }

    fun saveToFavourites() {
        launchWithLoading {
            comicModelLiveData.value?.let { interactor.saveComicToFavourites(it) }
        }
    }

    private fun getNewComicWithSetCurrentNumber(comicFunction: suspend () -> ComicModel) {
        launchWithLoading {
            val comicModel = comicFunction()
            currentComicNumber = comicModel.comicNum
            _comicModelLiveData.value = comicModel
        }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<SearchComicViewModel> {

        override fun create(arguments: Bundle): SearchComicViewModel
    }
}