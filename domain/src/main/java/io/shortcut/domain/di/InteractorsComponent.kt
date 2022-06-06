package io.shortcut.domain.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [InteractorsModule::class],
    dependencies = [RepositoriesProvider::class]
)
interface InteractorsComponent: InteractorsProvider {

    companion object {

        fun create(repositoriesProvider: RepositoriesProvider): InteractorsComponent {
            return DaggerInteractorsComponent.builder()
                .repositoriesProvider(repositoriesProvider)
                .build()
        }
    }
}