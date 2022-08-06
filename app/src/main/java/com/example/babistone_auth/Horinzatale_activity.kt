package com.example.babistone_auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.babistone_auth.R
import com.example.babistone_auth.adapteur.HorienzotaleAdapteur
import com.example.babistone_auth.model.fashio_model

class Horinzatale_activity : AppCompatActivity() {

    private lateinit var recyclerview : RecyclerView

    val liste_fashion = ArrayList<fashio_model>()
    val display = ArrayList<fashio_model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_horinzatale)
        recyclerview = findViewById(R.id.Horiz_Recy)

        liste_fashion.add(fashio_model("chemise",100,R.drawable.casque))
        liste_fashion.add(fashio_model("chemisier",100,R.drawable.casque))
        liste_fashion.add(fashio_model("chemise 3",100,R.drawable.casque))
        liste_fashion.add(fashio_model("chemise 4",100,R.drawable.casque))
        display.addAll(liste_fashion)

        recyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerview.adapter = adapteur


    }
}