package com.example.renit.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.ToolbarBindingAdapter
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.renit.R
import com.example.renit.adapters.CategoriesAdPostAdapter
import com.example.renit.databinding.CategoriesAdPostBinding
import com.example.renit.models.Category
import com.example.renit.models.SubCategory
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_home.*

class CategoriesAdPostFragment : Fragment(), CategoriesAdPostAdapter.AdPostCategoryListner {

    private var selectedCategory = Category()
    lateinit var CategoriesAdPostFragment : CategoriesAdPostBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        var categorylist = ArrayList<Category>()

/*            Categorylist.add(
                Category(
                    "cricket",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS3-KtExMO-J4Ug7vRkfAja4G95a5JI1_bHXzGsJTva0fSMd2ni"

                )
            )
            Categorylist.add(
                Category(
                    "Football",
                    "https://www.telegraph.co.uk/content/dam/football/2019/08/15/TELEMMGLPICT000206110274_trans_NvBQzQNjv4BqrS8Z1b0ZQjNoViJZ3HnGQ4NS1YurETCFkeLSh1IwB7c.jpeg?imwidth=450"
                )
            )
            Categorylist.add(
                Category(
                    "Hockey",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSMSeF4bs0LdEYzbjOKr3CjqA0OYnzUxYKFS1hHaYlk_958L8HY"
                )
            )
            Categorylist.add(
                Category(
                    "Bowling",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTIEQ0w5Xw3M_QIr5bbj0XoTqt3QRlG_d_LmAC5LX26Z0Z6rrrX"
                )
            )

        Categorylist.add(
            Category(
                "cricket",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS3-KtExMO-J4Ug7vRkfAja4G95a5JI1_bHXzGsJTva0fSMd2ni"

            )
        )*/


            // Inflate the layout for this fragment
      /*  CategoriesAdPostFragment = DataBindingUtil.inflate(inflater, R.layout.categories_ad_post, container, false)
        val manager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        manager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        var firebaseReference = FirebaseDatabase.getInstance().getReference("/Category/vehicle")
        categorylist.add(Category("vehicle","Vehicle","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS3-KtExMO-J4Ug7vRkfAja4G95a5JI1_bHXzGsJTva0fSMd2ni"))
        firebaseReference.setValue(categorylist[0]).addOnSuccessListener {
            Toast.makeText(context,"added",Toast.LENGTH_SHORT).show()
        }*/


/*
        var firebaseReference1 = FirebaseDatabase.getInstance().getReference("/SubCategory/marriageHall").push()
        val key = firebaseReference1.key
        subCategorylist.add(SubCategory(key,"Marquee "))
        subCategorylist.add(SubCategory(key,"Banquet Halls"))
       // subCategorylist.add(SubCategory(key,"Stand Fan"))
        firebaseReference1.setValue(subCategorylist[1]).addOnSuccessListener {
            Toast.makeText(context,"added",Toast.LENGTH_SHORT).show()
        }
*/


        CategoriesAdPostFragment = DataBindingUtil.inflate(inflater, R.layout.categories_ad_post, container, false)

        val manager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        manager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        CategoriesAdPostFragment.recyclerviewCategoriesAdPost.layoutManager = manager


        var firebaseRefrence = FirebaseDatabase.getInstance().getReference("Category")
        firebaseRefrence.addValueEventListener(object : ValueEventListener{

        override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(context,p0.message,Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(p0: DataSnapshot) {
                categorylist.clear()
                for(data in p0.children){
                    val category: Category? = data.getValue(Category::class.java)
                    categorylist.add(category!!)
                }

                CategoriesAdPostFragment.recyclerviewCategoriesAdPost.adapter = CategoriesAdPostAdapter(categorylist,this@CategoriesAdPostFragment)

            }


        })
        return CategoriesAdPostFragment.root

    }

    override fun adPostCategoryListener(category: Category) {
        Toast.makeText(context,category.title,Toast.LENGTH_SHORT).show()
        selectedCategory = category
        val action = CategoriesAdPostFragmentDirections.actionCategoriesAdPostFragmentToSubCategoryFragment(category)
        findNavController().navigate(action)

    }
}
