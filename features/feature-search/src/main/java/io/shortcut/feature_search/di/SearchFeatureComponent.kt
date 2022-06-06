package io.shortcut.feature_search.di

import dagger.Component
import io.shortcut.core_feature.di.AppComponentProvider
import io.shortcut.core_feature.di.FeatureScope
import io.shortcut.feature_search.fragments.SearchComicFragment

@FeatureScope
@Component(
    modules = [ViewModelModule::class],
    dependencies = [AppComponentProvider::class]
)
interface SearchFeatureComponent {

    fun inject(fragment: SearchComicFragment)

    companion object {

        fun create(appComponentProvider: AppComponentProvider): SearchFeatureComponent {
            return DaggerSearchFeatureComponent.builder()
                .appComponentProvider(appComponentProvider)
                .build()
        }
    }
}