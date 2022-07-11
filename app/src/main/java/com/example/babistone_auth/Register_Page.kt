package com.example.babistone_auth

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.register_page.*

class Register_Page : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var etEmail: EditText
    lateinit var etConfPass: EditText
    private lateinit var etPass: EditText
    private lateinit var btnSignUp: Button
    lateinit var tvRedirectLogin: TextView

    // create Firebase authentication object
    private lateinit var auth: FirebaseAuth


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

            title = "Creation du Compte"
            compte.setOnClickListener {
                Intent(this, Login_Page::class.java).also {
                    startActivity(it)
                }
            }
            btn_valider.setOnClickListener {
                if (mail.text.toString().isEmpty() || passeword.text.toString()
                        .isEmpty() || confirmer_password.text.toString().isEmpty()
                ) {
                    Toast.makeText(this, "Champ Vide", Toast.LENGTH_SHORT).show()
                } else if (passeword.text.toString() != confirmer_password.text.toString()) {
                    confirmer_password.error = "mot de passe different"
                } else {

                    /*
                     val editor = sharedPreferences.edit()
                    editor.putBoolean("is_authentificated", true)
                    editor.putString("nom", mail.text.toString())
                    editor.apply()
                     */

                    var act_home = Intent(this, Home_pageActivity::class.java)
                    startActivity(act_home)
                    finish()
                }
            }

        }
    }