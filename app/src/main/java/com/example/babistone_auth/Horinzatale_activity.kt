package com.example.babistone_auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.babistone_auth.R
import com.example.babistone_auth.adapteur.HorienzotaleAdapteur

class Horinzatale_activity : AppCompatActivity() {
    private lateinit var recyclerview : RecyclerView
    private lateinit var adapteur : HorienzotaleAdapteur

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horinzatale)
        recyclerview = findViewById(R.id.Horiz_Recy)
        adapteur = HorienzotaleAdapteur()
        recyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerview.adapter = adapteur


    }
}