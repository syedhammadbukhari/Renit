package com.example.renit.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.renit.models.Chat
import com.example.renit.R
import com.example.renit.adapters.ChatAdapter
import kotlinx.android.synthetic.main.fragment_chat.view.*

/**
 * A simple [Fragment] subclass.
 */
class ChatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var chat_list = listOf<Chat>(
            Chat(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Momina Siddique",
                "7:29pm",
                "Ever tried ever failed"
            ),
            Chat(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Umer Razak",
                "6:29am",
                "No matter"
            ),
            Chat(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Syed Hammad Bukhari",
                "9:29pm",
                "Try again"
            ),
            Chat(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Anique Sabir",
                "3:29am",
                "Fail again"
            ),
            Chat(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Usaman Jutt",
                "7:29pm",
                "Fail better"
            )
        )
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_chat, container, false)
        view.recyclerview_chat.adapter =
            ChatAdapter(chat_list)
        return view

    }


}
