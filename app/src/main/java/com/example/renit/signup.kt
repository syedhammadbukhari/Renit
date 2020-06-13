package com.example.renit

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.renit.databinding.FragmentSignupBinding
import com.example.renit.models.Reniter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_signup.*

class signup : Fragment() {

    private lateinit var signupBinding: FragmentSignupBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var emailText : String
    private lateinit var passwordText : String
    private lateinit var email : EditText
    private lateinit var password : EditText
    private lateinit var confirmPassword : EditText
    private lateinit var confirmPasswordText : String
    private lateinit var fullNameText : String
    private lateinit var fullName : EditText
    private lateinit var phoneNoText : String
    private lateinit var phoneNo : EditText
    private var firebaseDatabase = FirebaseDatabase.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        signupBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)

        hideKeyboard()
        emailText = String()
        passwordText = String()
        confirmPasswordText = String()
        email = signupBinding.emailSignUp
        password = signupBinding.passwordSignUp
        confirmPassword = signupBinding.condirmPasswordSignUp
        fullName = signupBinding.fullNameSignUp
        fullNameText = String()
        phoneNo = signupBinding.phoneNoSignUp
        phoneNoText = String()
        firebaseAuth = FirebaseAuth.getInstance()

        signupBinding.signInSignup.setOnClickListener {
            findNavController().navigate(R.id.action_signup_to_login3)
        }

        signupBinding.signupNowSignup.setOnClickListener {
            if (validateEmail() && validatePassword() && validatePasswordMatch() && validateFullName() && validatePhoneNo()) {
                hideKeyboard()
                falseFocus()
                //startLoading()
                createUser()
            }
        }

        return signupBinding.root
    }
    private fun createUser() {
        //Log.d("uid_register",uid)
        firebaseAuth.createUserWithEmailAndPassword(emailText, passwordText).addOnSuccessListener {
            val userProfileChangeRequest = UserProfileChangeRequest.Builder().setDisplayName(fullNameText).build()
            firebaseAuth.currentUser?.updateProfile(userProfileChangeRequest)
            val uid = FirebaseAuth.getInstance().currentUser?.uid
            val Reniter = Reniter(fullNameText,emailText,uid!!,phoneNoText)
            firebaseDatabase.getReference("/Reniter/$uid").setValue(Reniter).addOnSuccessListener {
                //stopLoading()
                falseFocus()
                Toast.makeText(context,"Your Account has been created successfully",Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_signup_to_verifyEmail)
            }

        }.addOnFailureListener{
            //stopLoading()
            trueFocus()
            Toast.makeText(context,it.message,Toast.LENGTH_LONG).show()
        }
    }
    private fun validateEmail(): Boolean {
        emailText = email.text.toString()
        if (emailText.isEmpty()) {
            email.error = "Please Enter email"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            email.error = "Please enter valid email"
            return false
        }
        return true
    }

    private fun validatePassword(): Boolean {
        passwordText = password.text.toString()
        if (passwordText.isEmpty()) {
            password.error = "Please enter a password"
            return false
        } else if (passwordText.length < 6) {
            password.error = "Please enter atleast 6 characters"
            return false
        }
        return true
    }

    private fun validateFullName(): Boolean {
        fullNameText = fullName.text.toString()
        if (fullNameText.isEmpty()) {
            fullName.error = "Please enter a user name"
            return false
        }
        return true
    }

    private fun validatePasswordMatch():Boolean{
        confirmPasswordText = confirmPassword.text.toString()
        if (confirmPasswordText.isEmpty()) {
            password.error = "Please enter a confirm password"
            return false
        } else if (confirmPasswordText != passwordText){
            password.error = "Password does not match"
            return false
        }
        return true
    }

    private fun falseFocus() {
        signupBinding.apply {
            emailSignUp.isFocusableInTouchMode = false
            passwordSignUp.isFocusableInTouchMode = false
            emailSignUp.isEnabled = false
            passwordSignUp.isEnabled = false
            signInSignup.isEnabled = false
        }

    }

    private fun trueFocus() {
        signupBinding.apply {
            emailSignUp.isFocusableInTouchMode = true
            passwordSignUp.isFocusableInTouchMode = true
            emailSignUp.isEnabled = true
            passwordSignUp.isEnabled = true
            signInSignup.isEnabled = true
        }
    }
    private fun hideKeyboard(){
        val  imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }
    private fun validatePhoneNo():Boolean{
        phoneNoText = phoneNo.text.toString()
        if (phoneNoText.isEmpty()) {
            phoneNo.error = "Please enter a Phone no"
            return false
        }
        return true


    }
}


