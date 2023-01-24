package com.example.zadacha_3.storis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.zadacha_3.R
import com.example.zadacha_3.databinding.ItemViewpagerStorisBinding
import com.example.zadacha_3.model.Data


class MyAdapter : ListAdapter<Data,MyAdapter.NewViewHolder>(DiffUnits()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
       return NewViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_viewpager_storis,parent,false))
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        holder.bindImage(getItem(position).image)
        holder.bindText(getItem(position).text)
    }
  inner class NewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
      val binding = ItemViewpagerStorisBinding.bind(itemView)
      fun bindImage(image: Int){
          binding.imageViewseconAct.setImageResource(image)
      }
      fun bindText(text: String){
          binding.showTextStoris.text=text     }
  }
}
class DiffUnits: DiffUtil.ItemCallback<Data>(){
    override fun areItemsTheSame(oldItem: Data, newItem: Data)= oldItem.image ==newItem.image

    override fun areContentsTheSame(oldItem: Data, newItem: Data)= oldItem == newItem

}

