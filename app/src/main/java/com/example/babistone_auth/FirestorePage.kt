package com.example.babistone_auth

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class FirestorePage : AppCompatActivity() {



    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firestore_page)

        //Initialisez une instance de Cloud Firestore :


        add_value.setOnClickListener {
            db.collection("info_book")
                .add(add_book(name_book.text.toString(),autor.text.toString()))
                .addOnSuccessListener {
                    Toast.makeText(this, "livre ajouter", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "livre non ajouter", Toast.LENGTH_SHORT).show()
                }
        }

// Add a new document with a generated ID
    }
    private fun add_book(name_book:String, autor_name:String ){


    }
}