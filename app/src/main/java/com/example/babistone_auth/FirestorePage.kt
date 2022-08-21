package com.example.babistone_auth

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class FirestorePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        add_value.setOnClickListener {
            val namebook = name_book.text.toString()
            val autor_name = autor.text.toString()
           add_book(namebook,autor_name)

        }

    }
    private fun add_book(namebook:String, autor_name:String ){
        val db = FirebaseFirestore.getInstance()

        val book_info:MutableMap<String, Any> = HashMap()
        book_info["name_book"] = namebook
        book_info["name_autor"] = autor_name

        db.collection("info_book")
            .add(book_info)
            .addOnSuccessListener {
                Toast.makeText(this, "livre ajouter", Toast.LENGTH_SHORT).show()
                vide_case(name_book,autor)
            }
            .addOnFailureListener {
                Toast.makeText(this, "livre non ajouter", Toast.LENGTH_SHORT).show()
            }

    }
    private fun vide_case(case1:EditText,case2:EditText){
        case1.setText("")
        case2.setText("")
    }
}