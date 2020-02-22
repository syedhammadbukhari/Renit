package com.example.renit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.renit.models.Category
import com.example.renit.viewholder.CategoriesAdPostMyViewHolder

class CategoriesAdPostAdapter(var list: List<Category>): RecyclerView.Adapter<CategoriesAdPostMyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdPostMyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CategoriesAdPostMyViewHolder(
            inflater,
            parent
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }
    /*override fun getItemCount() = list.size */

    override fun onBindViewHolder(holder: CategoriesAdPostMyViewHolder, position: Int) {
        var ad_post_categories= list[position]
        holder.bind(ad_post_categories)
    }
}