package io.shortcut.core_navigation.di

import dagger.Binds
import dagger.Module
import io.shortcut.core_feature.router.Router
import io.shortcut.core_navigation.router_impl.RouterImpl
import javax.inject.Singleton

@Module
interface NavigationModule {

    @Singleton
    @Binds
    fun provideRouter(router: RouterImpl): Router
}