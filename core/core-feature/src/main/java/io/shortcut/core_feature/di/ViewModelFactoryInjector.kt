package io.shortcut.core_feature.di

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Reusable
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

@Reusable
class ViewModelFactoryInjector @Inject constructor(
    private val viewModelFactories: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<AssistedViewModelFactory<out ViewModel>>>
) {

    @Suppress("UNCHECKED_CAST")
    fun <VM : ViewModel> create(modelClass: KClass<out ViewModel>, args: Bundle): VM {
        val factory = object : ViewModelProvider.Factory {

            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return viewModelFactories[modelClass]?.get()?.create(args) as? T
                    ?: throw IllegalStateException("Unknown view model class $modelClass")
            }
        }
        return factory.create(modelClass.java) as VM
    }
}