package com.example.zadacha_4.kategoriya_Adapter

import android.widget.CompoundButton.OnCheckedChangeListener

data class NewCotegory(
    val name: String,
    var onChecked: Boolean = false,
    var id: Int = 0
)