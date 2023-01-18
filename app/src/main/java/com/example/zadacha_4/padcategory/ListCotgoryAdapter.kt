package com.example.zadacha_4.padcategory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.zadacha_4.R
import com.example.zadacha_4.databinding.ListPadcotegoryBinding

class ListCotgoryAdapter: ListAdapter<Listcotegory,ListCotgoryAdapter.ListViewHolder>(DiffUtils()) {
    val oclick : ((Int)-> (Unit))? = null

    inner class ListViewHolder(itemView: View):ViewHolder(itemView){
        private val binding = ListPadcotegoryBinding.bind(itemView)
        fun bindImage(inage: Int){
            binding.actionImage.setImageResource(inage)
        }
        fun bindTitle(title: String){
            binding.textTitle.text = title
        }
        fun bindText(text: String){
            binding.text.text = text
        }
        fun bindNarkh(narkh: Double){
            binding.textnarkh.text =narkh.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.list_padcotegory,parent,false)
       return ListViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
       holder.bindImage(getItem(position).image)
       holder.bindTitle(getItem(position).title)
       holder.bindText(getItem(position).textInfo)
       holder.bindNarkh(getItem(position).narkh)

    }

}
class DiffUtils:DiffUtil.ItemCallback<Listcotegory>() {
    override fun areItemsTheSame(oldItem: Listcotegory, newItem: Listcotegory): Boolean {
       return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Listcotegory, newItem: Listcotegory): Boolean {
      return oldItem== newItem
    }
}