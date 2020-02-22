package com.example.renit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.renit.viewholder.NewsfeedMyViewHolder
import com.example.renit.models.Newsfeed

class NewsfeedAdapter(var list:List<Newsfeed>): RecyclerView.Adapter<NewsfeedMyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsfeedMyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsfeedMyViewHolder(
            inflater,
            parent
        )
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: NewsfeedMyViewHolder, position: Int) {
        var newsfeed: Newsfeed =list[position]
        holder.bind(newsfeed)
    }

}