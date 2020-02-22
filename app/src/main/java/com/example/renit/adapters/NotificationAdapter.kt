package com.example.renit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.renit.models.Notification
import com.example.renit.viewholder.NotificationMyViewHolder

class NotificationAdapter(var list: List<Notification>): RecyclerView.Adapter<NotificationMyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationMyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NotificationMyViewHolder(
            inflater,
            parent
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }
    /*override fun getItemCount() = list.size */

    override fun onBindViewHolder(holder: NotificationMyViewHolder, position: Int) {
        var notification = list[position]
        holder.bind(notification)
    }
}