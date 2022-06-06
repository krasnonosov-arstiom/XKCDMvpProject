package io.shortcut.core_feature.layout

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.children
import androidx.core.view.isVisible
import io.shortcut.core_feature.databinding.LayoutProgressScrollLinearBinding

class ProgressScrollLinearLayout @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attributeSet, defStyleAttr), IProgressLayout {

    override var isProgressVisible: Boolean = false
        set(value) {
            binding.loadingImageView.isVisible = value
            loadingAnimation(value)
            field = value
        }

    private val binding by lazy {
        LayoutProgressScrollLinearBinding.inflate(
            LayoutInflater.from(context), this, true
        )
    }
    private var loadingAnimation: AnimationDrawable? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        val content = children.toList()
        removeAllViews()
        loadingAnimation = binding.loadingImageView.background as AnimationDrawable
        content.forEach { binding.viewContainer.addView(it) }
    }

    private fun loadingAnimation(value: Boolean) {
        if (value) loadingAnimation?.start() else loadingAnimation?.stop()
    }
}