package com.example.renit.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.renit.R
import com.example.renit.models.Notification
import com.squareup.picasso.Picasso

class NotificationMyViewHolder(inflator: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflator.inflate(R.layout.single_layout_notification,parent,false)){
    private var image: ImageView? = null
    private var username: TextView? = null
    private var desciprion: TextView? = null
    private var time: TextView? = null
    init {
        image = itemView.findViewById(R.id.imageview_notification)
        username= itemView.findViewById(R.id.username_notification)
        desciprion= itemView.findViewById(R.id.description_notification)
        time= itemView.findViewById(R.id.time_notification)
    }
    fun bind(chat: Notification){
        username!!.text = chat.name_notification
        desciprion!!.text = chat.description_notification
        time!!.text = chat.time_notification
        Picasso.get().load(chat.image_notification).fit().into(image)
    }
}