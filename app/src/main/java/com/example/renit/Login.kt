package com.example.renit


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
        signIn_btn_login.setOnClickListener {
            val email = mobileNumberOrEmail_login.text.toString()
            val pass = password_login.text.toString()
        }
        signup_login_.setOnClickListener{
            
        }
    }
}
