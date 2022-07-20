package com.example.babistone_auth

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
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

    private  var mail = ""
    private var paswrd = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createACount.setOnClickListener {
            startActivity(Intent(this,RegisteActivity::class.java))

        }
        //configuration de la boite de dialogue
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Patienter")
        progressDialog.setMessage("creation du compte")
        progressDialog.setCanceledOnTouchOutside(false)


        firebaseAuth = FirebaseAuth.getInstance()
        binding.connectBtnUp.setOnClickListener {
            validata()
        }

    }

    private fun validata() {
        mail = binding.mailBinUp.text.toString().trim()
        paswrd = binding.passwordBinUp.text.toString().trim()
        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            binding.mailBinUp.error = "mail invalide"
        }else if (
            TextUtils.isEmpty(paswrd)){
            binding.passwordBinUp.error = "Entre un mot de passe"
        }
        else{
            firebaseSignUp()
        }

    }

    private fun firebaseSignUp() {
        progressDialog.show()
        firebaseAuth.createUserWithEmailAndPassword(mail,paswrd)
            .addOnSuccessListener {

                progressDialog.dismiss()
                val firebaseuser = firebaseAuth.currentUser
                val mail = firebaseuser!!.email
                Toast.makeText(this, "compte creer avec succes", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,Home_pageActivity::class.java))
                finish()
            }
            .addOnFailureListener {
                progressDialog.dismiss()
                Toast.makeText(this, "Echec de creation verifier votre connexion", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}