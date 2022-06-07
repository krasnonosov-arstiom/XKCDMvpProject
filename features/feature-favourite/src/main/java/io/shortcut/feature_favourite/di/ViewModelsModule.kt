package io.shortcut.feature_favourite.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.shortcut.core_feature.di.AssistedViewModelFactory
import io.shortcut.core_feature.di.FeatureScope
import io.shortcut.core_feature.di.ViewModelKey
import io.shortcut.feature_favourite.viewmodels.FavouriteViewModel

@Module
interface ViewModelsModule {

    @FeatureScope
    @Binds
    @IntoMap
    @ViewModelKey(FavouriteViewModel::class)
    fun providesFavouriteViewModel(viewModel: FavouriteViewModel.Factory): AssistedViewModelFactory<out ViewModel>
}