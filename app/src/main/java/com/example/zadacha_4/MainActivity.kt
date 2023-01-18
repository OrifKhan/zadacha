package com.example.zadacha_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zadacha_4.databinding.ActivityMainBinding
import com.example.zadacha_4.kategoriya_Adapter.NewCotegory
import com.example.zadacha_4.kategoriya_Adapter.NewListAdapter
import com.example.zadacha_4.padcategory.ListCotgoryAdapter
import com.example.zadacha_4.padcategory.Listcotegory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var recyclerView: RecyclerView
    lateinit var listrecyclerView: RecyclerView

    var adapter = NewListAdapter()
    var listadapter = ListCotgoryAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCotegory()
        getListCotegory()

    }

    fun getCotegory() {

        recyclerView = binding.recyclerView11
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter.submitList(getnewItem())
        recyclerView.adapter = adapter

    }

    private fun getListCotegory() {

        binding.listCotegory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.listCotegory.adapter = listadapter
        setList3()
        adapter.onClick = { it ->
            adapter.submitList(getnewItem(it))

            when (it) {
                1 -> {
                    setList1()
                }
                2 -> {
                    setList2()
                }
            }
        }
    }

    fun setList1() {

        listadapter.submitList(
            mutableListOf(
                Listcotegory(
                    R.drawable.img,
                    "Pitzza", "pitzzapitzzapitzzapitzzapitzzapitzza", 94.0
                ), Listcotegory(
                    R.drawable.img,
                    "Pitzza", "pitzzapitzzapitzzapitzzapitzzapitzza", 94.0
                ), Listcotegory(
                    R.drawable.img2,
                    "Pitzza", "pitzzapitzzapitzzapitzzapitzzapitzza", 94.0
                ), Listcotegory(
                    R.drawable.img4,
                    "Pitzza", "pitzzapitzzapitzzapitzzapitzzapitzza", 94.0
                ), Listcotegory(
                    R.drawable.imga3,
                    "Pitzza", "pitzzapitzzapitzzapitzzapitzzapitzza", 94.0
                )
            )
        )
    }

    fun setList2() {

        listadapter.submitList(
            mutableListOf(
                Listcotegory(
                    R.drawable.drink,
                    "coloclola", "pitzzapitzzapitzzapitzzapitzzapitzza", 94.0
                ),
                Listcotegory(
                    R.drawable.cocacola,
                    "coloclola", "pitzzapitzzapitzzapitzzapitzzapitzza", 94.0
                ),
                Listcotegory(
                    R.drawable.cocacola,
                    "coloclola", "pitzzapitzzapitzzapitzzapitzzapitzza", 94.0
                )
            )
        )
    }

    fun setList3() {

        listadapter.submitList(
            mutableListOf(
                Listcotegory(
                    R.drawable.imga3,
                    "Pitzza", "pitzzapitzzadfodfpitzzapitzzapitzzapitzza", 94.0
                )
            )
        )
    }

    fun getnewItem(indexofelemen: Int? = null): MutableList<NewCotegory> {
        val list = mutableListOf(
            NewCotegory("Комбо "),
            NewCotegory("Закуски"),
            NewCotegory("Напиток"),
            NewCotegory("Пицца")
        )
        list.forEachIndexed { index, newCogetory ->
            if (indexofelemen == index) {
                newCogetory.onChecked = true
            }
        }
        return list
    }
}
