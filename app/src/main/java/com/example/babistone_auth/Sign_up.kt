package com.example.babistone_auth

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.babistone_auth.databinding.ActivityRegisteBinding
import com.example.babistone_auth.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class Sign_up : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var actionBar: ActionBar
    //progress
    private lateinit var progressDialog: ProgressDialog
    //firebasse
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configuration de la boite de dialogue
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Patienter")
        progressDialog.setMessage("creation du compte")
        progressDialog.setCanceledOnTouchOutside(false)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}