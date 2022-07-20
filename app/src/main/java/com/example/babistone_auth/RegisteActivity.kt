package com.example.babistone_auth

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.ActionBar
import com.example.babistone_auth.databinding.ActivityRegisteBinding
import com.google.firebase.auth.FirebaseAuth

class RegisteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegisteBinding
    private lateinit var actionBar: ActionBar
    //progress
    private lateinit var progressDialog:ProgressDialog
    //firebasse
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configuration de la boite de dialogue
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Patienter")
        progressDialog.setMessage("chargement encours")
        progressDialog.setCanceledOnTouchOutside(false)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()
    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            startActivity(Intent(this,Home_pageActivity::class.java))
            finish()
        }
    }
}