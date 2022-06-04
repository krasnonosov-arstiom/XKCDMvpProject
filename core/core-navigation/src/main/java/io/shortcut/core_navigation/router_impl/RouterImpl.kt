package io.shortcut.core_navigation.router_impl

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import io.shortcut.core_feature.router.Router
import javax.inject.Inject

class RouterImpl @Inject constructor(private val navController: NavController) : Router {

    private fun navigate(@IdRes destinationId: Int) {
        navController.navigate(destinationId)
    }

    private fun navigate(@IdRes destinationId: Int, arguments: Bundle) {
        navController.navigate(destinationId, arguments)
    }
}