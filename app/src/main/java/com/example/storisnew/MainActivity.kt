package com.example.storisnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.storisnew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : NewStorisAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = NewStorisAdapter()
        adapter.submitList(getList())

        adapter.onClickl = { pos ->

            val newList = mutableListOf<NewStoris>()
            val previousList = adapter.currentList

            for (itemIndex in previousList.indices){
                if (itemIndex == pos){
                    val newStoris  = previousList[pos].copy(show = true)
                    newList.add(newStoris)
                }else {
                    newList.add(previousList[itemIndex])
                }
            }
            adapter.submitList(newList)

        }

        recyclerView = binding.reycler

        recyclerView.adapter = adapter

    }

    private fun getList() : MutableList<NewStoris> {
        val list = mutableListOf<NewStoris>()

            list.add(NewStoris(R.drawable.drink))
            list.add(NewStoris(R.drawable.img))
            list.add(NewStoris(R.drawable.img1))

        return list
    }
}