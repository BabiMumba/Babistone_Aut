package com.example.babistone_auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.babistone_auth.R
import kotlinx.android.synthetic.main.activity_detaille.*

class DetailleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detaille)
        var intent = intent

        //recuperation des inforamations
        val image = intent.getIntExtra("image",R.drawable.pec)
        val nom = intent.getStringExtra("nom")
        val prix = intent.getDoubleExtra("prix",0.0)


        img_detaille.setImageResource(image)
        nom_article_deta.setText(nom)
        prix_deta.text = prix.toString()

    }
}