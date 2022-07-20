package com.example.babistone_auth

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.babistone_auth.databinding.ActivityHomePageBinding
import com.example.babistone_auth.databinding.ActivityRegisteBinding
import com.google.firebase.auth.FirebaseAuth

class Home_pageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding
    private lateinit var actionBar: ActionBar
    //firebasse

    lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

    }

    private fun checkUser() {
     val firebaseUser = firebaseAuth.currentUser
     if (firebaseUser != null){
         val email = firebaseUser.email
         binding.txt1.text = email

     }else{
         startActivity(Intent(this,Home_pageActivity::class.java))
         finish()
     }
    }
}