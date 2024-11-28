package com.example.submission_dicoding

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val name: String,
    val position: String,
    val imageUrl: Int,
    val bio: String
) : Parcelable
