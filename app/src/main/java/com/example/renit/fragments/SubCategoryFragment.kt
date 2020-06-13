package com.example.renit.fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.renit.R
import com.example.renit.adapters.SubCategoryAdapter
import com.example.renit.models.Category
import com.example.renit.models.SubCategory
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.subcategory.*
import kotlinx.android.synthetic.main.subcategory.view.*

class SubCategoryFragment : Fragment() {

    lateinit var subCategory_List : ArrayList<SubCategory>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        subCategory_List = ArrayList()
        val view = inflater.inflate(R.layout.subcategory, container, false)
        val obj = SubCategoryFragmentArgs.fromBundle(arguments!!).category
        Toast.makeText(context,obj.title,Toast.LENGTH_SHORT).show()
        view.subcategoryHeading.text = obj.title + " Sub Category"

       FirebaseDatabase.getInstance().getReference("SubCategory/${obj.id}").addValueEventListener(object :ValueEventListener{
           override fun onCancelled(p0: DatabaseError) {
           }


           override fun onDataChange(p0: DataSnapshot) {

               p0.children.forEach{
                   val subCategory = it.getValue(SubCategory::class.java)
                   subCategory_List.add(subCategory!!)
               }
               view?.recyclerview_sub_category?.adapter =  SubCategoryAdapter(subCategory_List)
           }

       })

        return view
    }
}
