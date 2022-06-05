package io.shortcut.data.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import io.shortcut.domain.di.RepositoriesProvider
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoriesModule::class, NetworkModule::class, DatabaseModule::class, ApiServiceModule::class])
interface RepositoriesComponent: RepositoriesProvider {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): RepositoriesComponent
    }

    companion object {

        fun create(context: Context): RepositoriesComponent {
            return DaggerRepositoriesComponent.builder()
                .context(context)
                .build()
        }
    }
}