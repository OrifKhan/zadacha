package com.example.zadacha_3.view.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.zadacha_3.R

class Adapter(val listSearch: ArrayList<Int>):RecyclerView.Adapter<Adapter.ViewHolder>() {
    var itemOncklik: ((Int)-> Unit)?=null
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView : ImageView =itemView.findViewById(R.id.imageSearch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  item = LayoutInflater.from(parent.context).inflate(R.layout.recycler_search,parent,false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.imageView.setImageResource(listSearch[position])
        holder.imageView.setOnClickListener(){
           itemOncklik?.invoke(listSearch[position])
        }
    }

    override fun getItemCount(): Int {
       return listSearch.size
    }
}