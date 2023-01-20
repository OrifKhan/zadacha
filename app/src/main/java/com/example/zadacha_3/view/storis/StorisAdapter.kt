package com.example.zadacha_3.storis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

import com.example.zadacha_3.R
import com.example.zadacha_3.databinding.ItemStorisBinding
import com.example.zadacha_3.model.Storis

class StorisAdapter: ListAdapter<Storis, StorisAdapter.NewViewHolder>(NewDiffUnits()) {
    var itemOnClick: ((Int) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        return NewViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_storis, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
       holder.bindImage(getItem(position))
        holder.bindText(getItem(position))
    }
    inner class NewViewHolder(itemView: View) : ViewHolder(itemView) {
        private val binding = ItemStorisBinding.bind(itemView)
        fun bindImage(image: Storis){
            binding.imageViewstoris.setImageResource(image.imegStoris)
            binding.imageViewstoris.setOnClickListener(){
                itemOnClick?.invoke(adapterPosition)
                binding.imageViewstoris.setStrokeColorResource(R.color.white)
                image.oncheck =true
        }
     }
        fun bindText(text: Storis){
            binding.textStoris.text = text.textStoris
        }
    }
}
class NewDiffUnits: DiffUtil.ItemCallback<Storis>(){
    override fun areItemsTheSame(oldItem: Storis, newItem: Storis): Boolean = oldItem.textStoris == newItem.textStoris

    override fun areContentsTheSame(oldItem: Storis, newItem: Storis): Boolean = oldItem == newItem

}
