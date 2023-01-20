package com.example.zadacha_3.view.storis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.zadacha_3.databinding.ActivityStorisShowBinding
import com.example.zadacha_3.storis.MyAdapter
import com.example.zadacha_3.viewmodel.MyViewModel
import kotlin.math.abs

class StorisActivitiy : AppCompatActivity() {
    lateinit var binding: ActivityStorisShowBinding
    lateinit var adapter: MyAdapter
    private var myViewModel = MyViewModel()
      var idForOnClick=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStorisShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        idForOnClick = intent.getIntExtra("hi", 0)

        adapter = MyAdapter()
        adapter.submitList(myViewModel.getList())
        binding.viewPager2.adapter = adapter
        binding.viewPager2.setPageTransformer(getTransformation())
    }


    private fun getTransformation(): CompositePageTransformer {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(30))
        transformer.addTransformer { page, position ->
            page.scaleY = 0.85f + (1 - abs(position)) * 0.15f

        }
        return transformer
    }


}