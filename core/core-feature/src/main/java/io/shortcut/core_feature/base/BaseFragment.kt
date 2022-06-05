package io.shortcut.core_feature.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import io.shortcut.core_feature.R
import io.shortcut.core_feature.di.AppComponentProvider
import io.shortcut.core_feature.di.AppComponentProviderHolder
import io.shortcut.core_feature.di.NavigationRouterProvider
import io.shortcut.core_feature.di.ViewModelFactoryInjector
import io.shortcut.core_feature.router.Router
import kotlin.reflect.KClass

abstract class BaseFragment<B : ViewBinding, VM : BaseViewModel> : Fragment() {

    abstract val viewModelFactoryInjector: ViewModelFactoryInjector

    abstract val viewModelClass: KClass<out BaseViewModel>

    private var _binding: B? = null
    val binding: B
        get() = checkNotNull(_binding) {
            "Binding hasn't been initialized"
        }

    private var _viewModel: VM? = null
    val viewModel: VM
        get() = checkNotNull(_viewModel) {
            "ViewModel hasn't been initialized"
        }

    private var _router: Router? = null
    val router: Router
        get() = checkNotNull(_router) {
            "Router hasn't been initialized"
        }

    abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?): B

    abstract fun inject(appComponentProvider: AppComponentProvider)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.applicationContext?.let {
            if (it is AppComponentProviderHolder) {
                inject(it.appComponentProvider)
            }
        }
        if (context is NavigationRouterProvider) {
            _router = context.router
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewModel = viewModelFactoryInjector.create(viewModelClass, arguments ?: bundleOf())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = initBinding(inflater, container)
        return binding.root
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.errorLiveEvent.observe(viewLifecycleOwner) {
            Snackbar.make(
                view,
                it.localizedMessage ?: getString(R.string.standard_error_text),
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    override fun onDetach() {
        _viewModel = null
        _router = null
        _binding = null
        super.onDetach()
    }
}