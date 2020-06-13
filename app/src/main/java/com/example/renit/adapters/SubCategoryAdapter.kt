package com.example.renit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.renit.models.SubCategory
import com.example.renit.viewholder.SubCategoryViewHolder

class SubCategoryAdapter(var list: List<SubCategory>): RecyclerView.Adapter<SubCategoryViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SubCategoryViewHolder(
            inflater,
            parent
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }
    /*override fun getItemCount() = list.size */

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        var subcategory = list[position]
        holder.bind(subcategory)
    }

}