package com.example.zadacha_3.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zadacha_3.R

class PostAtabter(val listPost: ArrayList<Post>): RecyclerView.Adapter<PostAtabter.PostsViewHilder>() {
    
    inner class PostsViewHilder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgPost = itemView.findViewById<ImageView>(R.id.imgpost)
        val imgProfil = itemView.findViewById<ImageView>(R.id.imgprofil)
        val textUser=itemView.findViewById<TextView>(R.id.textUser2)
        val itemLike= itemView.findViewById<ImageView>(R.id.like)
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
        holder.itemLike.setOnClickListener(){

        }
    }

    override fun getItemCount(): Int {
        return listPost.size
    }
}