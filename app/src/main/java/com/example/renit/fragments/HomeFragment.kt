package com.example.renit.fragments


import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.renit.adapters.CategoryAdapter
import com.example.renit.R
import com.example.renit.databinding.FragmentHomeBinding
import com.example.renit.models.Category
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var HomeFragment: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        HomeFragment = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        /*account_home.setOnClickListener{
            val addNewPost =  BottomSheetDialog(context!!.applicationContext)
            val view = layoutInflater.inflate(R.layout.addnewpost_home_bottom_sheet,null)
            addNewPost.setContentView(view)
            addNewPost.show()


        }*/

        // Inflate the layout for this fragment


        HomeFragment.addNewPostHome.setOnClickListener {

            findNavController().navigate(R.id.action_home_to_categoriesAdPostFragment)

        }
           /* var categorylist = listOf<Category>(
                Category(
                    "Car",
                    "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                ),
                Category(
                    "Car",
                    "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                ),
                Category(
                    "Car",
                    "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                ),
                Category(
                    "Car",
                    "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                ),
                Category(
                    "Car",
                    "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                ),
                Category(
                    "Car",
                    "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                ),
                Category(
                    "Car",
                    "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                ),
                Category(
                    "Car",
                    "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                ),
                Category(
                    "Car",
                    "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                ),
                Category(
                    "Car",
                    "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                ),
                Category(
                    "Car",
                    "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                ),
                Category(
                    "Car",
                    "https://images.pexels.com/photos/736716/pexels-photo-736716.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                )

            )


            HomeFragment.recyclerviewCategoriesHome.adapter = CategoryAdapter(categorylist)*/
        return HomeFragment.root

    }



}
