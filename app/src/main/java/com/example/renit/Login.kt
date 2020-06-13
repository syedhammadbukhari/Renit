package com.example.renit


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.renit.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase


/**
 * A simple [Fragment] subclass.
 */
class Login : Fragment() {

    private lateinit var fragmentLoginBinding: FragmentLoginBinding
    //private lateinit var callbackManager: CallbackManager
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var emailText: String
    private lateinit var passwordText: String
    private lateinit var email: TextView
    private lateinit var password: TextView
    private lateinit var currentUser: FirebaseUser
    private var currentUserId = String()
    private var firebaseDatabase = FirebaseDatabase.getInstance()
    private var databaseReference = firebaseDatabase.reference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        fragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        hideKeyboard()
        emailText = String()
        passwordText = String()
        email = fragmentLoginBinding.Emaillogin
        password = fragmentLoginBinding.passwordLogin
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance()

        fragmentLoginBinding.signupLogin.setOnClickListener {
            findNavController().navigate(R.id.action_login3_to_signup)
        }

        fragmentLoginBinding.forgetPasswordLogin.setOnClickListener {
            findNavController().navigate(R.id.action_login3_to_resetPassword)
        }
        fragmentLoginBinding.loginBtnLogin.setOnClickListener {
            getDataAndSignIn()
        }

        return fragmentLoginBinding.root
    }




    private fun getDataAndSignIn() {

        if (validateEmail() && validatePassword()){
            hideKeyboard()
            falseFocus()
            //startLoading()
            firebaseAuth.signInWithEmailAndPassword(emailText,passwordText).addOnSuccessListener {
                currentUser = FirebaseAuth.getInstance().currentUser!!
                currentUserId = currentUser.uid
                val intent = Intent(context,MainActivity::class.java)
                startActivity(intent)
           /*     when {
                    emailVerified() -> {
                        //stopLoading()
                        trueFocus()
                        )
                    }
                    else -> {
                        //stopLoading()
                        trueFocus()
                        findNavController().navigate(R.id.action_login3_to_verifyEmail)
                    }
                }*/
            }.addOnFailureListener{
               // stopLoading()
                trueFocus()
                Toast.makeText(context,it.message,Toast.LENGTH_LONG).show()
            }
        }
        else{
            validateEmail()
            validatePassword()
        }
    }


    private fun emailVerified():Boolean{
        return currentUser!!.isEmailVerified
    }

/*    private fun isValid():Boolean{
        var check = false
        databaseReference.child("khiladi$currentUserId").addValueEventListener(object :
            ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                val khiladi = p0.getValue(Reniter::class.java)
                if(khiladi?.email == currentUser?.email){
                    check = true
                }

            }

        })
        return check
    }*/

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

/*    private fun stopLoading(){
        fragmentLoginBinding.loginBtnLogin.startAnimation()
        fragmentLoginBinding.loginBtnLoginFragment.revertAnimation()
    }

    private fun startLoading(){
        fragmentLoginBinding.loginBtnLoginFragment.startAnimation()
    }*/

    private fun falseFocus(){
        fragmentLoginBinding.apply {
            Emaillogin.isFocusableInTouchMode =  false
            passwordLogin.isFocusableInTouchMode = false
            Emaillogin.isEnabled = false
            passwordLogin.isEnabled = false
            btnFbLogin.isEnabled = false
            signupLogin.isEnabled = false
            forgetPasswordLogin.isEnabled = false
        }
    }

    private fun trueFocus(){
        fragmentLoginBinding.apply {
            Emaillogin.isFocusableInTouchMode = true
            passwordLogin.isFocusableInTouchMode = true
            Emaillogin.isEnabled = true
            passwordLogin.isEnabled = true
            btnFbLogin.isEnabled = true
            signupLogin.isEnabled = true
            forgetPasswordLogin.isEnabled = true
        }
    }

    private fun hideKeyboard() {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)

    }
}

