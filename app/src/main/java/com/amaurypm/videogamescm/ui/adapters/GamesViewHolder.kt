package com.amaurypm.videogamescm.ui.adapters


import androidx.recyclerview.widget.RecyclerView
import com.amaurypm.videogamescm.R
import com.amaurypm.videogamescm.data.remote.model.GameDto
import com.amaurypm.videogamescm.databinding.ItemGameBinding
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class GamesViewHolder(
    private val binding: ItemGameBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(game: GameDto){

        binding.apply {
            tvTitle.text = game.title

            //Usando Glide
            Glide.with(binding.root.context)
                .load(game.thumbnail)
                .error(R.drawable.loading)
                .into(ivThumbnail)

            //Usando Picasso
            /*Picasso.get()
                .load(game.thumbnail)
                .error(R.drawable.loading)
                .into(ivThumbnail)*/

        }
    }
}