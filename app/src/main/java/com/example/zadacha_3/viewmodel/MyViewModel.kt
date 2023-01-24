package com.example.zadacha_3.viewmodel

import com.example.zadacha_3.R
import com.example.zadacha_3.model.Data
import com.example.zadacha_3.model.Post
import com.example.zadacha_3.model.Storis

class MyViewModel {
    fun getPost(): MutableList<Post> {
        val listPost= mutableListOf<Post>()
        listPost.add(Post(R.drawable.img1, R.drawable.person1, "User11"))
        listPost.add(Post(R.drawable.img11, R.drawable.img2, "User12"))
        listPost.add(Post(R.drawable.img10, R.drawable.img3, "User13"))
        listPost.add(Post(R.drawable.img9, R.drawable.person2, "User14"))
        listPost.add(Post(R.drawable.person4, R.drawable.img5, "User15"))
        listPost.add(Post(R.drawable.img7, R.drawable.person3, "User16"))
        listPost.add(Post(R.drawable.img6, R.drawable.img7, "User17"))
        listPost.add(Post(R.drawable.person1, R.drawable.person3, "User18"))
        listPost.add(Post(R.drawable.img4, R.drawable.img9, "User19"))
        return listPost
    }

    fun getStoris(): MutableList<Storis> {
        val list = mutableListOf<Storis>()
        list.add(Storis(R.drawable.person2, "User1", false))
        list.add(Storis(R.drawable.img2, "User2"))
        list.add(Storis(R.drawable.person4, "User3"))
        list.add(Storis(R.drawable.img4, "User4"))
        list.add(Storis(R.drawable.person1, "User5"))
        list.add(Storis(R.drawable.img6, "User6"))
        return list
    }

    fun getListById(id: Int): List<Data> {
        val list: List<Data>

        when (id) {
            0 -> {
                list = listOf<Data>(
                    Data(R.drawable.img2, "user"),
                    Data(R.drawable.img10, "user"),
                    Data(R.drawable.img1, "user"),
                )
            }
            1 -> {
                list = listOf<Data>(
                    Data(R.drawable.img3, "Sochi"),
                    Data(R.drawable.img4, "Sochi"),
                    Data(R.drawable.img5, "Sochi"),
                )
            }
            else -> {
                list = listOf<Data>(
                    Data(R.drawable.img3, "Moscow"),
                    Data(R.drawable.img4, "Sochi"),
                    Data(R.drawable.img5, "Dushanbe"),
                )
            }

        }
        return list
    }
}