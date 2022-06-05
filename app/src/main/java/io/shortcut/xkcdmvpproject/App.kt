package io.shortcut.xkcdmvpproject

import android.app.Application
import io.shortcut.core_feature.di.AppComponentProvider
import io.shortcut.core_feature.di.AppComponentProviderHolder
import io.shortcut.data.di.RepositoriesComponent
import io.shortcut.domain.di.InteractorsComponent
import io.shortcut.xkcdmvpproject.di.AppComponent

class App : Application(), AppComponentProviderHolder {

    private var _appComponentProvider: AppComponentProvider? = null
    override val appComponentProvider: AppComponentProvider
        get() = checkNotNull(_appComponentProvider) {
            "AppComponentProvider hasn't been initialized"
        }

    override fun onCreate() {
        setUpDI()
        super.onCreate()
    }

    private fun setUpDI() {
        val repositoriesProvider = RepositoriesComponent.create(applicationContext)
        val interactorsProvider = InteractorsComponent.create(repositoriesProvider)
        _appComponentProvider = AppComponent.create(interactorsProvider)
    }
}