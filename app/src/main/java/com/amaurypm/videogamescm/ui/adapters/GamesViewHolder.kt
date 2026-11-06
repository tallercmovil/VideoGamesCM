package com.amaurypm.videogamescm.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.amaurypm.videogamescm.data.remote.model.GameDto
import com.amaurypm.videogamescm.databinding.ItemGameBinding

class GamesViewHolder(
    private val binding: ItemGameBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(game: GameDto){

        binding.apply {
            tvTitle.text = game.title
        }
    }
}