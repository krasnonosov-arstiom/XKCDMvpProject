package io.shortcut.xkcdmvpproject.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.Lazy
import io.shortcut.core_feature.di.NavigationRouterProvider
import io.shortcut.core_feature.router.Router
import io.shortcut.xkcdmvpproject.R
import io.shortcut.xkcdmvpproject.di.ActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NavigationRouterProvider {

    @Inject
    lateinit var _router: Lazy<Router>

    override val router: Router
        get() = _router.get()

    override fun onCreate(savedInstanceState: Bundle?) {
        ActivityComponent.create(supportFragmentManager, R.id.nav_host_fragment).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}