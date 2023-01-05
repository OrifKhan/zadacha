package com.example.zadacha_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zadacha_3.databinding.ActivityMainBinding
import com.example.zadacha_3.posts.Post
import com.example.zadacha_3.posts.PostAtabter
import com.example.zadacha_3.search.SearchActivity
import com.example.zadacha_3.storis.Storis
import com.example.zadacha_3.storis.StorisActivitiy
import com.example.zadacha_3.storis.StorisAdapter

class MainActivity : AppCompatActivity() {
     lateinit var recyclerView: RecyclerView
     lateinit var adapter: StorisAdapter
     lateinit var adaptersecon:PostAtabter
      private val list = ArrayList<Storis>()
      private val listPost = ArrayList<Post>()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        initsecon()
    }

    fun  initsecon(){
        recyclerView= findViewById(R.id.recycleViewPost)
        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        getPost()
        adaptersecon = PostAtabter(listPost)
        recyclerView.adapter=adaptersecon
    }





    fun init(){
        recyclerView= findViewById(R.id.recyclerViewstoris)
        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        getStoris()
        adapter = StorisAdapter(list)
        recyclerView.adapter=adapter
        adapter.itemOnClick ={
            val intent = Intent(this, StorisActivitiy::class.java)
            intent.putExtra("storis",it)
            startActivity(intent)
        }
        val intent =Intent(this,SearchActivity::class.java)
        binding.btNvItem.setOnItemSelectedListener(){
            when(it.itemId){
             R.id.search ->{
                 startActivity(intent)
             }
             R.id.glavni -> {}
            }
            true
        }
        adapter.itemOnClick={
            it.
        }


    }

    private fun getStoris() {
        list.add(Storis(R.drawable.person2,"User1"))
        list.add(Storis(R.drawable.img2,"User2"))
        list.add(Storis(R.drawable.person4,"User3"))
        list.add(Storis(R.drawable.img4,"User4"))
        list.add(Storis(R.drawable.person1,"User5"))
        list.add(Storis(R.drawable.img6,"User6"))
    }
    private fun getPost() {
     listPost.add(Post(R.drawable.img1,R.drawable.person1,"User11"))
     listPost.add(Post(R.drawable.img11,R.drawable.img2,"User12"))
     listPost.add(Post(R.drawable.img10,R.drawable.img3,"User13"))
     listPost.add(Post(R.drawable.img9,R.drawable.person2,"User14"))
     listPost.add(Post(R.drawable.person4,R.drawable.img5,"User15"))
     listPost.add(Post(R.drawable.img7,R.drawable.person3,"User16"))
     listPost.add(Post(R.drawable.img6,R.drawable.img7,"User17"))
     listPost.add(Post(R.drawable.person1,R.drawable.person3,"User18"))
     listPost.add(Post(R.drawable.img4,R.drawable.img9,"User19"))
    }
}