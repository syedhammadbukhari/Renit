package com.example.renit.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.renit.R
import com.example.renit.models.Category
import com.squareup.picasso.Picasso

class CategoriesAdPostMyViewHolder(inflator: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflator.inflate(R.layout.single_layout_categories_ad_post,parent,false)){
    private var image: ImageView? = null
    private var title: TextView? = null
    init {
        image = itemView.findViewById(R.id.imageview_adPost_single_layout)
        title = itemView.findViewById(R.id.textview_adPost_single_layout)
    }
    fun bind(category: Category){
        title!!.text = category.title
        Picasso.get().load(category.image).fit().into(image)
    }
}