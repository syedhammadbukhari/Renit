package com.example.renit.viewholder

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.renit.R
import com.example.renit.models.Newsfeed


class NewsfeedMyViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.single_layout_newsfeed,parent,false)){

    private var profilePic: ImageView? = null
    private var userName: TextView? =null // "?" we use it to hold null values
    private var likeButton: ImageView?=null
    private var productImage: ImageView?=null
    private var productTitle: TextView?=null
    private var productPrice: TextView?=null
    init{
        profilePic = itemView.findViewById(R.id.imageView_newsfeed_home)
        userName=itemView.findViewById(R.id.UserName_newsfeed_home)
        likeButton=itemView.findViewById(R.id.like_newsfeed_home)
        productImage=itemView.findViewById(R.id.imageView2_newsfeed_home)
        productTitle=itemView.findViewById(R.id.productTitle_newsfeed_home)
        productPrice=itemView.findViewById(R.id.productPrice_newsfeed_home)
    }
    fun bind(ads: Newsfeed){
        Picasso.get().load(ads.Profile_pic).fit().into(productImage)
        userName?.text=ads.UserName
        Picasso.get().load(ads.ProductImages).fit().into(productImage)
        productTitle?.text=ads.ProductTitle
        productPrice?.text=ads.ProductPrice

    }


}