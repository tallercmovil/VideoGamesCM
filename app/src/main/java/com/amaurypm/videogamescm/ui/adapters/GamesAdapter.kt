package com.amaurypm.videogamescm.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amaurypm.videogamescm.data.remote.model.GameDto
import com.amaurypm.videogamescm.databinding.ItemGameBinding

class GamesAdapter(
    private val games: List<GameDto>,
    private val onGameClick: (GameDto) -> Unit
): RecyclerView.Adapter<GamesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GamesViewHolder {
        val binding = ItemGameBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GamesViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: GamesViewHolder,
        position: Int
    ) {
        val game = games[position]

        holder.bind(
            game
        )

        holder.itemView.setOnClickListener {
            onGameClick(game)
        }
    }

    override fun getItemCount(): Int = games.size
}