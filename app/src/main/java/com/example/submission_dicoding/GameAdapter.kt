package com.example.submission_dicoding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(private val players: List<Game>, private val onClick: (Game) -> Unit) :
    RecyclerView.Adapter<GameAdapter.PlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.bind(player, onClick)
    }

    override fun getItemCount() = players.size

    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(player: Game, onClick: (Game) -> Unit) {
            itemView.findViewById<TextView>(R.id.nameTextView).text = player.name
            itemView.findViewById<TextView>(R.id.positionTextView).text = player.position
            itemView.findViewById<ImageView>(R.id.playerImageView).setImageResource(player.imageUrl)

            itemView.setOnClickListener { onClick(player) }
        }
    }
}
