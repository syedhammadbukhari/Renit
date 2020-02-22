package com.example.renit.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.renit.R
import com.example.renit.models.Chat
import com.squareup.picasso.Picasso

class ChatMyViewHolder(inflator: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflator.inflate(R.layout.single_layout_chat,parent,false)){
    private var image: ImageView? = null
    private var username: TextView? = null
    private var time: TextView? = null
    private var msg: TextView? = null
    init {
        image = itemView.findViewById(R.id.imageview_chat)
        username= itemView.findViewById(R.id.username_chat)
        time= itemView.findViewById(R.id.time_chat)
        msg= itemView.findViewById(R.id.msg_chat)
    }
    fun bind(chat: Chat){
        username!!.text = chat.name_chat
        time!!.text = chat.time_chat
        msg!!.text = chat.msg_chat
        Picasso.get().load(chat.image_chat).fit().into(image)
    }
}