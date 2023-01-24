package com.example.zadacha_3.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zadacha_3.R
import com.example.zadacha_3.model.Post

class PostAtabter(val listPost: MutableList<Post>): RecyclerView.Adapter<PostAtabter.PostsViewHilder>() {
    
    inner class PostsViewHilder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgPost = itemView.findViewById<ImageView>(R.id.imgpost)
        val imgProfil = itemView.findViewById<ImageView>(R.id.imgprofil)
        val textUser=itemView.findViewById<TextView>(R.id.textUser2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHilder {
        val imageView = LayoutInflater.from(parent.context).inflate(R.layout.postrecycle,parent,false)
        return PostsViewHilder(imageView)
    }

    override fun onBindViewHolder(holder: PostsViewHilder, position: Int) {
        val postItem = listPost[position]
        holder.imgProfil.setImageResource(postItem.profilImage)
        holder.imgPost.setImageResource(postItem.postImage)
        holder.textUser.text = postItem.textPost

    }

    override fun getItemCount(): Int {
        return listPost.size
    }
}