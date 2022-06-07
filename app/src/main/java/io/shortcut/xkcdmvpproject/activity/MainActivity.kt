package io.shortcut.xkcdmvpproject.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
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

    private val bottomNavigationView: BottomNavigationView by lazy { findViewById(R.id.bottom_navigation_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        ActivityComponent.create(supportFragmentManager, R.id.nav_host_fragment).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
        navHostFragment?.navController?.let { bottomNavigationView.setupWithNavController(it) }
    }
}