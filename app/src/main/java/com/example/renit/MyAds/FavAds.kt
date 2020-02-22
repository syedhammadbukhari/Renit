package com.example.renit.MyAds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.renit.R

class FavAds : Fragment()  {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View? {
        var view = inflater.inflate(R.layout.fragment_ads, container, false)
        return view
    }

}
