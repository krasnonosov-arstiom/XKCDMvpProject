package io.shortcut.core_feature.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        handleError(throwable)
    }

    override val coroutineContext: CoroutineContext = errorHandler

    val errorLiveEvent = LiveEvent<Throwable>()

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> = _loadingLiveData

    private fun handleError(throwable: Throwable) {
        errorLiveEvent.value = throwable
    }

    fun launchWithLoading(function: suspend () -> Unit) {
        val showLoadingJob = viewModelScope.launch {
            delay(DELAY_BEFORE_LOADING)
            _loadingLiveData.value = true
        }
        viewModelScope.launch {
            try {
                function()
            } finally {
                showLoadingJob.cancel()
                _loadingLiveData.value = false
            }
        }
    }

    companion object {

        private const val DELAY_BEFORE_LOADING = 200L
    }
}