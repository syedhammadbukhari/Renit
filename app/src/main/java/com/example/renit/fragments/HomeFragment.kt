package com.example.renit.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.renit.Home.Adapter_Category
import com.example.renit.adapters.NewsfeedAdapter
import com.example.renit.models.Newsfeed
import com.example.renit.Home.Category
import com.example.renit.R
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        /*account_home.setOnClickListener{
            val addNewPost =  BottomSheetDialog(context!!.applicationContext)
            val view = layoutInflater.inflate(R.layout.addnewpost_home_bottom_sheet,null)
            addNewPost.setContentView(view)
            addNewPost.show()


        }*/

        // Inflate the layout for this fragment


        var categorylist = listOf<Category>(
            Category(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Car"
            ),
            Category(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Car"
            ),
            Category(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Car"
            ),
            Category(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Car"
            ),
            Category(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Car"
            ),
            Category(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Car"
            ),
            Category(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Car"
            ),
            Category(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Car"
            ),
            Category(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Car"
            ),
            Category(
                "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Car"
            )

        )

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.recyclerview_categories_home.adapter = Adapter_Category(categorylist)




        return view

    }



}
