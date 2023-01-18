package com.example.storisnew

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.storisnew.databinding.ItemStorisBinding

class NewStorisAdapter: ListAdapter<NewStoris, NewStorisAdapter.StorisViewHolder>(NewDiffUnit()) {
  var onClickl : ((Int)->(Unit)) = {  }

    inner class StorisViewHolder(itemView: View):ViewHolder(itemView){
     val binding = ItemStorisBinding.bind(itemView)
        fun bind(image: NewStoris){
            binding.imageStoris.setImageResource(image.image)
             if (image.show){
                 binding.imageStoris.setStrokeColorResource(R.color.white)
                 image.show =false
             }
        }
            init{
            binding.imageStoris.setOnClickListener() {
                onClickl.invoke(adapterPosition)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StorisViewHolder {
       return StorisViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_storis,parent, false))
    }

    override fun onBindViewHolder(holder: StorisViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}



class NewDiffUnit(): DiffUtil.ItemCallback<NewStoris>(){
    override fun areItemsTheSame(oldItem: NewStoris, newItem: NewStoris): Boolean = oldItem == newItem


    override fun areContentsTheSame(oldItem: NewStoris, newItem: NewStoris): Boolean = oldItem == newItem


}