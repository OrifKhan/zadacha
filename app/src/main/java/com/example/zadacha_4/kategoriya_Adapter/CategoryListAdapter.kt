package com.example.zadacha_4.kategoriya_Adapter


import androidx.recyclerview.widget.DiffUtil

class DiffUtils : DiffUtil.ItemCallback<NewCotegory>() {
    override fun areItemsTheSame(oldItem: NewCotegory, newItem: NewCotegory): Boolean =
        oldItem == newItem


    override fun areContentsTheSame(oldItem: NewCotegory, newItem: NewCotegory): Boolean =
        oldItem == newItem
}