package io.shortcut.feature_search.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import com.bumptech.glide.Glide
import io.shortcut.core_feature.R
import io.shortcut.core_feature.base.BaseFragment
import io.shortcut.core_feature.base.BaseViewModel
import io.shortcut.core_feature.di.AppComponentProvider
import io.shortcut.core_feature.di.ViewModelFactoryInjector
import io.shortcut.core_feature.utils.hideKeyboard
import io.shortcut.domain.models.ComicModel
import io.shortcut.feature_search.databinding.FragmentSearchComicBinding
import io.shortcut.feature_search.di.SearchFeatureComponent
import io.shortcut.feature_search.viewmodels.SearchComicViewModel
import javax.inject.Inject
import kotlin.reflect.KClass

class SearchComicFragment : BaseFragment<FragmentSearchComicBinding, SearchComicViewModel>() {

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        viewModel.comicModelLiveData.observe(viewLifecycleOwner) {
            populateComicForm(it)
        }
    }

    private fun setListeners() {
        binding.nextComicButton.setOnClickListener { viewModel.getNextComic() }
        binding.previousComicButton.setOnClickListener { viewModel.getPreviousComic() }
        binding.randomComicButton.setOnClickListener { viewModel.getRandomComic() }
        binding.searchRequestEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                viewModel.getComicWithNumber(binding.searchRequestEditText.text.toString().toLong())
                hideKeyboard()
                return@setOnEditorActionListener true
            }
            false
        }
        binding.saveToFavouritesButton.setOnClickListener { viewModel.saveToFavourites() }
    }

    private fun populateComicForm(model: ComicModel) {
        binding.searchRequestEditText.setText(model.comicNum.toString())
        binding.comicTitle.text = model.title
        Glide.with(this@SearchComicFragment)
            .load(model.img)
            .into(binding.comicImageView)
        binding.comicAltTextView.text = model.alt
        binding.comicDate.text =
            getString(R.string.date_placeholder, model.day, model.month, model.year)
    }
}