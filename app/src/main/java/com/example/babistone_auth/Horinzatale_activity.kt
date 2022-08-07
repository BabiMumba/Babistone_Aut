package com.example.babistone_auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.babistone_auth.R
import com.example.babistone_auth.adapteur.Category2
import com.example.babistone_auth.adapteur.HorienzotaleAdapteur
import com.example.babistone_auth.model.fashio_model
import kotlinx.android.synthetic.main.activity_horinzatale.*

class Horinzatale_activity : AppCompatActivity() {

    //premier
    val liste_fashion = ArrayList<fashio_model>()
    //deuxieme
    val liste_fashion2 = ArrayList<fashio_model>()
    //troisieme
    val liste_fashion3 = ArrayList<fashio_model>()

    val display = ArrayList<fashio_model>()
    val display2 = ArrayList<fashio_model>()
    val display3 = ArrayList<fashio_model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horinzatale)


        liste_fashion.add(fashio_model("Humberguer",300.0,R.drawable.marie))
        liste_fashion.add(fashio_model("Pc lenovo",350.0,R.drawable.marie))
        liste_fashion.add(fashio_model("chemise 2",1500.0,R.drawable.marie))
        liste_fashion.add(fashio_model("banane",1200.0,R.drawable.air_pot))
        liste_fashion2.add(fashio_model("casque",3400.0,R.drawable.marie))
        liste_fashion2.add(fashio_model("figurine chat noir",900.0,R.drawable.marie))
        liste_fashion2.add(fashio_model("beignet",200.0,R.drawable.marie))
        liste_fashion2.add(fashio_model("bible",120.0,R.drawable.marie))
        liste_fashion3.add(fashio_model("marienette",50.0,R.drawable.marie))
        liste_fashion3.add(fashio_model("Humbergeur",20.0,R.drawable.marie))
        liste_fashion3.add(fashio_model("figurine alya",10.0,R.drawable.marie))
        liste_fashion3.add(fashio_model("laptop tactil",640.0,R.drawable.marie))

        display.addAll(liste_fashion)
        display2.addAll(liste_fashion2)
        display3.addAll(liste_fashion3)


        val adapteur = HorienzotaleAdapteur(this,display)
        val adapteur2 = Category2(this,display2)
        val adapteur3 = Category2(this,display3)

        Horiz_Recy.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        category2.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        category3.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        Horiz_Recy.adapter = adapteur
        category2.adapter = adapteur2
        category3.adapter = adapteur3


    }

}