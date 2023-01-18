package com.example.zadacha_4.kategoriya_Adapter
import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.view.ContentInfoCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.zadacha_4.R
import com.example.zadacha_4.R.*
import com.example.zadacha_4.databinding.KategotyaLayoutBinding
import com.google.android.material.internal.ContextUtils.getActivity

class NewListAdapter: ListAdapter<NewCotegory, NewListAdapter.NewViewHolder>(DiffUtils()){
   var onClick: ((Int)->(Unit))? = null


    inner class NewViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = KategotyaLayoutBinding.bind(itemView)

        fun bind(newText: NewCotegory){
            binding.textView.text = newText.name
            if (newText.onChecked){
                binding.textView.setBackgroundColor(ContextCompat.getColor(itemView.context,color.oranege
                ))
                binding.textView.setTextColor(ContextCompat.getColor(itemView.context,color.oranege_200))
            }     else{
                binding.textView.setBackgroundColor(ContextCompat.getColor(itemView.context, color.grin))
                binding.textView.setTextColor(ContextCompat.getColor(itemView.context,R.color.black_200))
            }

        }
        init {
            binding.root.setOnClickListener(){
           onClick?.invoke(adapterPosition)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val inflater  = LayoutInflater.from(parent.context)
            .inflate(layout.kategotya_layout,parent,false)
        return NewViewHolder(inflater)
    }



    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
       holder.bind(getItem(position))


    }
}













