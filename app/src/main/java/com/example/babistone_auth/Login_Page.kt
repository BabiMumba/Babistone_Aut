package com.example.babistone_auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login_page.*
import kotlinx.android.synthetic.main.register_page.*


class Login_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)
        title="Connexion"

        create_a_count.setOnClickListener {
            Intent(this,Register_Page::class.java).also {
                startActivity(it)
            }
        }
    }
}