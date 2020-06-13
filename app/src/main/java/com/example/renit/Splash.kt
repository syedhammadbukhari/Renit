package com.example.renit

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.renit.databinding.FragmentSignupBinding
import com.example.renit.models.Reniter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Splash : Fragment() {

    private lateinit var fragmentSplashBinding: FragmentSignupBinding
    private var currentUser  = FirebaseAuth.getInstance().currentUser
    private  var currentUserId = String()
    private var auth = FirebaseAuth.getInstance()
    private var firebaseDatabase =  FirebaseDatabase.getInstance()
    private var databaseReference =  firebaseDatabase.reference

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth.currentUser?.reload()?.addOnSuccessListener{
            currentUser = auth.currentUser
        }
        if (currentUser == null){
            findNavController().navigate(R.id.action_splash_to_login3)
        }
        else{
            if (!currentUser!!.isEmailVerified){
                findNavController().navigate(R.id.action_splash_to_verifyEmail)
            }
            else{
                var intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }


 /*   private fun isValid() {

        databaseReference.child("Reniter$currentUserId").addValueEventListener(object :
            ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                val reniter = p0.getValue(Reniter::class.java)
                if (reniter!=null){
                    val intent = Intent(context,MainActivity::class.java)
                    startActivity(intent)
                }
                else{
                    if(currentUser!!.isEmailVerified){
                        val intent = Intent(context, MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        val intent = Intent(context, VerifyEmail::class.java)
                        startActivity(intent)
                    }
                }


            }

        })
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

}