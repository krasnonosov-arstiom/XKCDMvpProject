package io.shortcut.feature_search.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.shortcut.core_feature.di.AssistedViewModelFactory
import io.shortcut.core_feature.di.FeatureScope
import io.shortcut.core_feature.di.ViewModelKey
import io.shortcut.feature_search.viewmodels.SearchComicViewModel

@Module
interface ViewModelModule {

    @FeatureScope
    @Binds
    @IntoMap
    @ViewModelKey(SearchComicViewModel::class)
    fun provideSearchComicViewModel(viewModel: SearchComicViewModel.Factory): AssistedViewModelFactory<out ViewModel>
}