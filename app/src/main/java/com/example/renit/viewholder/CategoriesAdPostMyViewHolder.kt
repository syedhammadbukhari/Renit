package com.example.renit.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.renit.R
import com.example.renit.models.Category
import com.squareup.picasso.Picasso

class CategoriesAdPostMyViewHolder(inflator: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflator.inflate(R.layout.single_layout_categories_ad_post,parent,false)){
    private var image1: ImageView? = null
    private var image2: ImageView? = null
    init {
        image1 = itemView.findViewById(R.id.Category_Image1_ad_post)
        image2 = itemView.findViewById(R.id.Category_Image2_ad_post)
    }
    fun bind(category: Category){
        Picasso.get().load(category.title).fit().into(image1)
        Picasso.get().load(category.image).fit().into(image2)
    }
}