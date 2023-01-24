package com.example.zadacha_3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zadacha_3.R
import com.example.zadacha_3.databinding.ActivityMainBinding
import com.example.zadacha_3.view.search.SearchActivity
import com.example.zadacha_3.model.Storis
import com.example.zadacha_3.view.storis.StoryActivity
import com.example.zadacha_3.storis.StorisAdapter
import com.example.zadacha_3.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: StorisAdapter
    lateinit var adaptersecon: PostAtabter
    private var myViewModel = MyViewModel()
    lateinit var messenger: ImageButton
    lateinit var binding: ActivityMainBinding
    val idForClick: Array<Int>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initStoris()
        initsecon()
        onCklikImageButtonMessamger()
    }

    fun onCklikImageButtonMessamger() {
        messenger = binding.messamgerButton
        messenger.setOnClickListener() {
            val intent = Intent(this, MessnderActivity::class.java)
            startActivity(intent)
        }
    }


    fun initsecon() {
        recyclerView = binding.recycleViewPost
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adaptersecon = PostAtabter(myViewModel.getPost())
        recyclerView.adapter = adaptersecon
    }


    fun initStoris() {
        recyclerView = binding.recyclerViewstoris
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapter = StorisAdapter()
        adapter.submitList(myViewModel.getStoris())
        recyclerView.adapter = adapter
        adapter.itemOnClick = {
            val intent = StoryActivity.getIntent(this, it)
            startActivity(intent)

            val newList = mutableListOf<Storis>()
            val periodicList = adapter.currentList

            for (index in periodicList.indices) {
                if (index == it) {
                    val litess = periodicList[it].copy(oncheck = true)
                    newList.add(litess)
                } else {
                    newList.add(periodicList[index])
                }
                adapter.submitList(newList)
            }

        }
        val intent = Intent(this, SearchActivity::class.java)
        binding.btNvItem.setOnItemSelectedListener() {
            when (it.itemId) {
                R.id.search -> {
                    startActivity(intent)
                }
                R.id.glavni -> {}
            }
            true
        }


    }

}

