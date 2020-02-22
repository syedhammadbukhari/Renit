package com.example.renit.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter_Category(var list: List<Category>):RecyclerView.Adapter<MyViewHolder_Category>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder_Category{
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder_Category(inflater,parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    /*override fun getItemCount() = list.size */

    override fun onBindViewHolder(holder: MyViewHolder_Category, position: Int) {
        var category= list[position]
        holder.bind(category)
    }
}