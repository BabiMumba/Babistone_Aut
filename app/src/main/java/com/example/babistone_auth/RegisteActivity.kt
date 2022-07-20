package com.example.babistone_auth

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import androidx.appcompat.app.ActionBar
import com.example.babistone_auth.databinding.ActivityRegisteBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registe.*
import java.util.regex.Pattern

class RegisteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegisteBinding
    private lateinit var actionBar: ActionBar
    //progress
    private lateinit var progressDialog:ProgressDialog
    //firebasse
    lateinit var firebaseAuth: FirebaseAuth
    private  var mail = ""
    private var paswrd = ""

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
        binding.connectBtn.setOnClickListener {
            validadta()


        }
    }

    private fun validadta() {

        mail = binding.mailBin.text.toString().trim()
        paswrd = binding.passwordBin.text.toString().trim()
        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            binding.mailBin.error = "mail invalide"
        }else if (
            TextUtils.isEmpty(paswrd)){
            binding.passwordBin.error = "Entre un mot de passe"
            }
        else{
            firebaseLogin()
        }
    }

    private fun firebaseLogin() {

    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            startActivity(Intent(this,Home_pageActivity::class.java))
            finish()
        }
    }
}