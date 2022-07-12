package com.example.babistone_auth

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.login_page.*
import kotlinx.android.synthetic.main.register_page.*


class Login_Page : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)
        auth = Firebase.auth

        title="Connexion"
        btn_login.setOnClickListener {
            var mail = mail_login.text.toString()
            var mpasse = mpass_login.text.toString()

            btn_login.setOnClickListener {

                if (mail.isEmpty()||mpasse.isEmpty()){
                    Toast.makeText(this, "non text", Toast.LENGTH_SHORT).show()
                }else{

                }
            }



        }



    }
}