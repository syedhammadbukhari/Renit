package com.example.renit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.renit.models.Chat
import com.example.renit.viewholder.ChatMyViewHolder

class ChatAdapter(var list: List<Chat>): RecyclerView.Adapter<ChatMyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatMyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ChatMyViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    /*override fun getItemCount() = list.size */

    override fun onBindViewHolder(holder: ChatMyViewHolder, position: Int) {
        var chat = list[position]
        holder.bind(chat)
    }
}