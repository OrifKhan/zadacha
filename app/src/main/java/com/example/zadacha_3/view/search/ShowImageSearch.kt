package com.example.zadacha_3.view.search

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.zadacha_3.R

class ShowImageSearch : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_image_search)
        val image=intent.getIntExtra("img",1)
        val imageSearch= findViewById<ImageView>(R.id.imageSearchShow)
        imageSearch.setImageResource(image)
    }
}