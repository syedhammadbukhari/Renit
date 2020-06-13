package com.example.renit.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.renit.R
import com.example.renit.models.SubCategory

class SubCategoryViewHolder(inflator: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflator.inflate(R.layout.single_layout_sub_category,parent,false)){
    private var title: TextView? = null

    init {
        title= itemView.findViewById(R.id.subcategoryTitle)
    }
    fun bind(subcategory: SubCategory){
        title!!.text = subcategory.title
    }
}