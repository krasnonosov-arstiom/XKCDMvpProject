package io.shortcut.core_feature.base

import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    private val supervisorJob = SupervisorJob()
    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        handleError(throwable)
    }

    override val coroutineContext: CoroutineContext =
        supervisorJob + errorHandler + Dispatchers.Main

    val errorLiveEvent = LiveEvent<Throwable>()

    private fun handleError(throwable: Throwable) {
        errorLiveEvent.value = throwable
    }

    override fun onCleared() {
        supervisorJob.cancel()
        super.onCleared()
    }
}