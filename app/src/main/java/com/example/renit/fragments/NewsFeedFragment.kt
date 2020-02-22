package com.example.renit.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.renit.R
import com.example.renit.adapters.NewsfeedAdapter
import com.example.renit.models.Newsfeed
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_newsfeed.view.*

class NewsFeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var myAdsList = listOf<Newsfeed>(
            Newsfeed(
                "data:image/jpeg;base64,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",
                "Syed Hammad Bukhari",
                "https://icdn2.digitaltrends.com/image/digitaltrends/2020-lamborghini-huracan-evo-spyder-review-7-382x238-c.jpg",
                true,
                "Umer is a beautiful gay",
                "Lamborgini vision Smooth",
                "150000000000"
            ),
            Newsfeed(
                "data:image/jpeg;base64,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",
                "Umer Razzak",
                "https://icdn2.digitaltrends.com/image/digitaltrends/2020-lamborghini-huracan-evo-spyder-review-7-382x238-c.jpg",
                true,
                "Usman is a beautiful guy",
                "Lamborgini vision Smooth",
                "150000000000"
            ),
            Newsfeed(
                "data:image/jpeg;base64,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",
                "Syed Hammad Bukhari",
                "https://icdn2.digitaltrends.com/image/digitaltrends/2020-lamborghini-huracan-evo-spyder-review-7-382x238-c.jpg",
                true,
                "Umer is a beautiful guy",
                "Lamborgini vision Smooth",
                "150000000000"
            )
        )
        val view = inflater.inflate(R.layout.fragment_newsfeed, container, false)
        view.recyclerview_newsfeed_post.adapter = NewsfeedAdapter(myAdsList)
        return view
    }
}

