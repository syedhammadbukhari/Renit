package com.example.renit.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.renit.R
import com.squareup.picasso.Picasso

class MyViewHolder_Category(inflator:LayoutInflater,parent:ViewGroup):RecyclerView.ViewHolder(inflator.inflate(R.layout.single_layout_category,parent,false)){
    private var image:ImageView? = null
    private var title:TextView? = null
    init {
        image = itemView.findViewById(R.id.imageview_single_layout)
        title = itemView.findViewById(R.id.textview_single_layout)
    }
    fun bind(category: Category){
        title!!.text = category.title_category
        Picasso.get().load(category.image_category).fit().into(image)
    }
}