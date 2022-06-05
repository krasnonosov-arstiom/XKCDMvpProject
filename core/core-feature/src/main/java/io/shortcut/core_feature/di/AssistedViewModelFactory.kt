package io.shortcut.core_feature.di

import android.os.Bundle
import io.shortcut.core_feature.base.BaseViewModel

interface AssistedViewModelFactory<T: BaseViewModel> {

    fun create(arguments: Bundle): T
}