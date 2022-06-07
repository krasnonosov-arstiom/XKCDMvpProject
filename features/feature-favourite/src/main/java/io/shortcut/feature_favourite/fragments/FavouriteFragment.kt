package io.shortcut.feature_favourite.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import io.shortcut.core_feature.base.BaseFragment
import io.shortcut.core_feature.base.BaseViewModel
import io.shortcut.core_feature.di.AppComponentProvider
import io.shortcut.core_feature.di.ViewModelFactoryInjector
import io.shortcut.feature_favourite.adapter.FavouritesAdapter
import io.shortcut.feature_favourite.databinding.FragmentFavouriteBinding
import io.shortcut.feature_favourite.di.FavouriteFeatureComponent
import io.shortcut.feature_favourite.viewmodels.FavouriteViewModel
import javax.inject.Inject
import kotlin.reflect.KClass

class FavouriteFragment : BaseFragment<FragmentFavouriteBinding, FavouriteViewModel>() {

    @Inject
    override lateinit var viewModelFactoryInjector: ViewModelFactoryInjector

    override val viewModelClass: KClass<out BaseViewModel> = FavouriteViewModel::class

    private val adapter = FavouritesAdapter()

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentFavouriteBinding.inflate(inflater, container, false)

    override fun inject(appComponentProvider: AppComponentProvider) {
        FavouriteFeatureComponent.create(appComponentProvider).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModel.favouriteComicsLiveData.observe(viewLifecycleOwner) {
            binding.noFavouriteComicsTextView.isVisible = it.isEmpty()
            adapter.updateComicsList(it)
        }
    }

    //TODO add item decorator
    private fun initViews() {
        binding.favouritesComicsRecyclerView.adapter = adapter
    }
}