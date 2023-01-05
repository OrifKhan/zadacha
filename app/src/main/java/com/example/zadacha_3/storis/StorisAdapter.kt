package com.example.zadacha_3.storis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zadacha_3.R
import com.google.android.material.imageview.ShapeableImageView

class StorisAdapter(val listStoris: ArrayList<Storis>):RecyclerView.Adapter<StorisAdapter.ViewHolder>() {
    var itemOnClick: ((Storis) -> Unit)? = null

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imeg=itemView.findViewById<ShapeableImageView>(R.id.imageViewstoris)
        val text =itemView.findViewById<TextView>(R.id.textStoris)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val imageView = LayoutInflater.from(parent.context).inflate(R.layout.item_storis,parent,false)
        return ViewHolder(imageView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val stoirsView = listStoris[position]
        holder.imeg.setImageResource(stoirsView.imegStoris)
        holder.text.text=stoirsView.textStoris
        holder.imeg.setOnClickListener{
            itemOnClick?.invoke(stoirsView)
        }
    }

    override fun getItemCount(): Int {
        return listStoris.size
    }
}