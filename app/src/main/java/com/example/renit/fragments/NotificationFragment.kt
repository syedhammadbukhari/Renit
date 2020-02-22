package com.example.renit.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.renit.models.Notification
import com.example.renit.R
import com.example.renit.adapters.NotificationAdapter
import kotlinx.android.synthetic.main.fragment_notification.view.*

/**
 * A simple [Fragment] subclass.
 */
class NotificationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment



        var notification_list = listOf<Notification>(
            Notification(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Syed Hammad Bukhari",
                "is liked your Ad",
                "7:29am"
            ),
            Notification(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Momina Siddique",
                "is commented on your post",
                "2:00pm"
            )
        )
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_notification, container, false)
        view.recyclerview_notification.adapter =
            NotificationAdapter(notification_list)
        return view
    }


}
