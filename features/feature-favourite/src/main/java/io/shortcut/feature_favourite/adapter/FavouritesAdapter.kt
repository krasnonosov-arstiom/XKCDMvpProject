package io.shortcut.feature_favourite.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.shortcut.domain.models.ComicModelDB
import io.shortcut.feature_favourite.R
import io.shortcut.feature_favourite.databinding.ItemFavouriteComicBinding

class FavouritesAdapter : RecyclerView.Adapter<FavouritesAdapter.FavouriteViewHolder>() {

    private val comics = mutableListOf<ComicModelDB>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FavouriteViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_favourite_comic, parent, false
        )
    )

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        holder.populate(comics[position])
    }

    override fun getItemCount() = comics.size

    fun updateComicsList(newList: List<ComicModelDB>) {
        comics.clear()
        comics.addAll(newList)
        notifyDataSetChanged() //TODO replace with DiffUtil
    }

    inner class FavouriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemFavouriteComicBinding.bind(itemView)

        fun populate(modelDb: ComicModelDB) {
            binding.comicTitle.text = modelDb.title
            binding.comicDescription.text = modelDb.alt
            binding.comicImage.setImageBitmap(modelDb.img)
        }
    }
}