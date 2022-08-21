package com.example.babistone_auth

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class FirestorePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialisez une instance de Cloud Firestore :


        add_value.setOnClickListener {
            val namebook = name_book.text.toString()
            val autor = autor.text.toString()
           add_book(namebook,autor)
        }

// Add a new document with a generated ID
    }
    private fun add_book(name_book:String, autor_name:String ){
        val db = FirebaseFirestore.getInstance()
        val user:MutableMap<String, Any> = HashMap()
        user["name book"] = name_book
        user["name autor"] = autor_name

        db.collection("info_book")
            .add(user)
            .addOnSuccessListener {
                Toast.makeText(this, "livre ajouter", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "livre non ajouter", Toast.LENGTH_SHORT).show()
            }

    }
}