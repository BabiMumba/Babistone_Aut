package com.example.babistone_auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.babistone_auth.R
import com.example.babistone_auth.adapteur.HorienzotaleAdapteur
import com.example.babistone_auth.model.fashio_model
import kotlinx.android.synthetic.main.activity_horinzatale.*

class Horinzatale_activity : AppCompatActivity() {

    val liste_fashion = ArrayList<fashio_model>()
    val display = ArrayList<fashio_model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horinzatale)


        liste_fashion.add(fashio_model("chemise",100,R.drawable.chemise1))
        liste_fashion.add(fashio_model("chemise 2",300,R.drawable.chemise2))
        liste_fashion.add(fashio_model("banane",7500,R.drawable.air_pot))
        liste_fashion.add(fashio_model("casque",600,R.drawable.casque))
        liste_fashion.add(fashio_model("beignet",4500,R.drawable.beignet))
        liste_fashion.add(fashio_model("marienette",650,R.drawable.marie))
        liste_fashion.add(fashio_model("Humbergeur",12000,R.drawable.emburger))

        display.addAll(liste_fashion)
        val adapteur = HorienzotaleAdapteur(this,display)
        Horiz_Recy.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        Horiz_Recy.adapter = adapteur


    }

}