package com.example.zadacha_3.view.search

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.zadacha_3.R
import com.example.zadacha_3.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adaptor: Adapter
    private lateinit var listImage: ArrayList<Int>

    lateinit var binding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun init() {
        listImage = ArrayList()
        recyclerView = findViewById(R.id.recyc_search)
        adaptor = Adapter(listImage)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        recyclerView.adapter = adaptor
        adaptor.itemOncklik = {
            val intent = Intent(this, ShowImageSearch::class.java)
            intent.putExtra("img", it)
            startActivity(intent)
        }
        getlistSearch()


    }

    private fun getlistSearch() {
        listImage.add(R.drawable.person3)
        listImage.add(R.drawable.img2)
        listImage.add(R.drawable.img11)
        listImage.add(R.drawable.img8)
        listImage.add(R.drawable.person4)
        listImage.add(R.drawable.person3)
        listImage.add(R.drawable.img10)
        listImage.add(R.drawable.person4)
        listImage.add(R.drawable.person3)
        listImage.add(R.drawable.person2)
        listImage.add(R.drawable.person1)
    }

}