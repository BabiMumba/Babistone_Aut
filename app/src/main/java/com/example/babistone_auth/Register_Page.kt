package com.example.babistone_auth

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.register_page.*

class Register_Page : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var etEmail: EditText
    lateinit var etConfPass: EditText
    private lateinit var etPass: EditText
    private lateinit var btnSignUp: Button
    

    // create Firebase authentication object
     lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_page)
        /*
        sharedPreferences = this.getSharedPreferences("app_state", Context.MODE_PRIVATE)
        val isAuthentificated = sharedPreferences.getBoolean("is_authentificated", false)
        val nomSharedPreferences = sharedPreferences.getString("nom", "")
        if (isAuthentificated) {
            Intent(this, Home_pageActivity::class.java).also {
                it.putExtra("nom", nomSharedPreferences)
                startActivity(it)
            }
        }
         */

        etEmail = findViewById(R.id.mail)
        etConfPass = findViewById(R.id.confirmer_password)
        etPass = findViewById(R.id.passeword)
        btnSignUp = findViewById(R.id.btn_valider)

        auth = FirebaseAuth.getInstance()

            title = "Creation du Compte"
            compte.setOnClickListener {
                Intent(this, Login_Page::class.java).also {
                    startActivity(it)
                }
            }
            btn_valider.setOnClickListener {
                var mail =mail.text.toString()
                var password = passeword.text.toString()
                if (mail.isEmpty() || password.isEmpty()
                ) {
                    Toast.makeText(this, "Champ Vide", Toast.LENGTH_SHORT).show()
                }  else {
                    auth.createUserWithEmailAndPassword(mail,password)
                        .addOnCompleteListener(Login_Page()) { task ->
                            if (task.isSuccessful) {

                                progressbar.visibility = View.VISIBLE
                                Intent(this,Home_pageActivity::class.java).also {
                                    Toast.makeText(this, "compte creer avec succes", Toast.LENGTH_SHORT).show()
                                    startActivity(it)
                                }

                            } else {
                                Toast.makeText(
                                    this, "erreur d'enregistrement",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                        }

                }
            }

        }
    private fun createAccount(email: String, password: String) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(Register_Page()) { task ->
                if (task.isSuccessful) {

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(this, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }

                progressbar.visibility= View.VISIBLE
            }
    }

}