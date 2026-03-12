package com.example.praktam_2407051028.model
import androidx.annotation.DrawableRes

data class Fashion(
    val nama: String,
    val deskripsi: String,
    val harga: Int,
    @DrawableRes val imageRes: Int
)