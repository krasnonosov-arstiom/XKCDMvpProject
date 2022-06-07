package io.shortcut.feature_favourite.di

import dagger.Component
import io.shortcut.core_feature.di.AppComponentProvider
import io.shortcut.core_feature.di.FeatureScope
import io.shortcut.feature_favourite.fragments.FavouriteFragment

@FeatureScope
@Component(
    modules = [ViewModelsModule::class],
    dependencies = [AppComponentProvider::class]
)
interface FavouriteFeatureComponent {

    fun inject(fragment: FavouriteFragment)

    companion object {

        fun create(appComponentProvider: AppComponentProvider): FavouriteFeatureComponent {
            return DaggerFavouriteFeatureComponent.builder()
                .appComponentProvider(appComponentProvider)
                .build()
        }
    }
}