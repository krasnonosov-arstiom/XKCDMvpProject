package io.shortcut.xkcdmvpproject.di

import dagger.Component
import io.shortcut.core_feature.di.AppComponentProvider
import io.shortcut.domain.di.InteractorsProvider
import javax.inject.Singleton

@Singleton
@Component(dependencies = [InteractorsProvider::class])
interface AppComponent: AppComponentProvider {

    companion object {

        fun create(interactorsProvider: InteractorsProvider): AppComponent {
            return DaggerAppComponent.builder()
                .interactorsProvider(interactorsProvider)
                .build()
        }
    }
}