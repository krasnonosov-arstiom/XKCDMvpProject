package io.shortcut.xkcdmvpproject.di

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import dagger.BindsInstance
import dagger.Component
import io.shortcut.core_navigation.di.NavigationModule
import io.shortcut.xkcdmvpproject.activity.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class, NavigationModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun fragmentManager(fragmentManager: FragmentManager): Builder

        @BindsInstance
        fun navHostFragmentId(@IdRes navHostFragmentId: Int): Builder

        fun build(): ActivityComponent
    }

    companion object {

        fun create(
            fragmentManager: FragmentManager,
            @IdRes navHostFragmentId: Int
        ): ActivityComponent {
            return DaggerActivityComponent.builder()
                .fragmentManager(fragmentManager)
                .navHostFragmentId(navHostFragmentId)
                .build()
        }
    }
}