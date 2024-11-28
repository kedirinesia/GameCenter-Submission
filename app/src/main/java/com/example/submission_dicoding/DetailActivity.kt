package com.example.submission_dicoding

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val player = intent.getParcelableExtra<Game>("PLAYER")
        if (player != null) {
            findViewById<TextView>(R.id.nameTextView).text = player.name
            findViewById<TextView>(R.id.bioTextView).text = player.bio
            findViewById<ImageView>(R.id.profileImageView).setImageResource(player.imageUrl)
        }



    }


    private fun sharePlayerInfo(player: Game?) {
        if (player != null) {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Check out this player: ${player.name}\nBio: ${player.bio}")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }
}
