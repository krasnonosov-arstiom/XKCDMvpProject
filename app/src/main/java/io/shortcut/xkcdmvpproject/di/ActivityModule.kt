package io.shortcut.xkcdmvpproject.di

import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    fun provideNavController(
        fragmentManager: FragmentManager,
        navHostFragmentId: Int
    ): NavController {
        val navHostFragment =
            fragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment
        return navHostFragment.navController
    }
}