package io.shortcut.core_feature.di

import android.os.Bundle
import androidx.lifecycle.ViewModel

interface AssistedViewModelFactory<T: ViewModel> {

    fun create(arguments: Bundle): T
}