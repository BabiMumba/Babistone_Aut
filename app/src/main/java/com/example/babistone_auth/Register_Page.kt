package com.example.babistone_auth

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.register_page.*

class Register_Page : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_page)
        sharedPreferences = this.getSharedPreferences("app_state", Context.MODE_PRIVATE)
        val isAuthentificated = sharedPreferences.getBoolean("is_authentificated", false)
        val nomSharedPreferences = sharedPreferences.getString("nom", "")
        if (isAuthentificated) {
            Intent(this, Home_pageActivity::class.java).also {
                it.putExtra("nom", nomSharedPreferences)
                startActivity(it)
            }
        }
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

                    val editor = sharedPreferences.edit()
                    editor.putBoolean("is_authentificated", true)
                    editor.putString("nom", mail.text.toString())
                    editor.apply()
                    var act_home = Intent(this, Home_pageActivity::class.java)
                    startActivity(act_home)
                    finish()
                }
            }

        }
    }