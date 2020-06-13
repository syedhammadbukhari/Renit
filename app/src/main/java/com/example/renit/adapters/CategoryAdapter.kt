package com.example.renit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.renit.models.Category
import com.example.renit.viewholder.CategoryMyViewHolder

class CategoryAdapter(var list: List<Category>):RecyclerView.Adapter<CategoryMyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryMyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CategoryMyViewHolder(
            inflater,
            parent
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }
    /*override fun getItemCount() = list.size */

    override fun onBindViewHolder(holder: CategoryMyViewHolder, position: Int) {
        var category= list[position]
        holder.bind(category)
    }
}