package io.shortcut.feature_search.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import io.shortcut.core_feature.base.BaseFragment
import io.shortcut.core_feature.base.BaseViewModel
import io.shortcut.core_feature.di.AppComponentProvider
import io.shortcut.core_feature.di.ViewModelFactoryInjector
import io.shortcut.feature_search.databinding.FragmentSearchComicBinding
import io.shortcut.feature_search.di.SearchFeatureComponent
import io.shortcut.feature_search.viewmodels.SearchComicViewModel
import javax.inject.Inject
import kotlin.reflect.KClass

class SearchComicFragment: BaseFragment<FragmentSearchComicBinding, SearchComicViewModel>() {

    @Inject
    override lateinit var viewModelFactoryInjector: ViewModelFactoryInjector

    override val viewModelClass: KClass<out BaseViewModel> = SearchComicViewModel::class

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSearchComicBinding.inflate(inflater, container, false)

    override fun inject(appComponentProvider: AppComponentProvider) {
        SearchFeatureComponent.create(appComponentProvider).inject(this)
    }
}