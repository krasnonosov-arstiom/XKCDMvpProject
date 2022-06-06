package io.shortcut.core_feature.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    private val supervisorJob = SupervisorJob()
    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        handleError(throwable)
    }

    override val coroutineContext: CoroutineContext =
        supervisorJob + errorHandler + Dispatchers.Main

    val errorLiveEvent = LiveEvent<Throwable>()

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> = _loadingLiveData

    private fun handleError(throwable: Throwable) {
        errorLiveEvent.value = throwable
    }

    fun CoroutineScope.launchWithLoading(function: suspend () -> Unit) {
        val showLoadingJob = launch {
            delay(DELAY_BEFORE_LOADING)
            _loadingLiveData.value = true
        }
        launch {
            try {
                function()
            } finally {
                showLoadingJob.cancel()
                _loadingLiveData.value = false
            }
        }
    }

    override fun onCleared() {
        supervisorJob.cancel()
        super.onCleared()
    }

    companion object {

        private const val DELAY_BEFORE_LOADING = 200L
    }
}