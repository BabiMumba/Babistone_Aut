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
                if (mail.isBlank()||mpasse.isBlank()){
                    Toast.makeText(this, "no text", Toast.LENGTH_SHORT).show()
                }else{
                    auth.createUserWithEmailAndPassword(mail,mpasse)
                        .addOnCompleteListener(Login_Page()) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success")
                                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                                val user = auth.currentUser
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()
                            }

                }
            }

        }



    }
}