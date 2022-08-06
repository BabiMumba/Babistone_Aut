package com.example.babistone_auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.babistone_auth.adapteur.MainRecycler
import com.example.babistone_auth.model.allcategories

class MainActivity : AppCompatActivity() {
    private var  mainCategoryRecycler : RecyclerView? = null
    private var mainRecycler:MainRecycler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val allcategory: MutableList<allcategories> = ArrayList()
        allcategory.add(allcategories("nollywood"))
        allcategory.add(allcategories("papa babi"))
        allcategory.add(allcategories("pateur kamael"))
        allcategory.add(allcategories("maman noela"))


    }

    private fun setMainCategory(allcategories: List<allcategories>){

        mainCategoryRecycler = findViewById(R.id.recycler)
        val layoutManager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        mainCategoryRecycler!!.layoutManager
        mainRecycler = MainRecycler(this,allcategories)
        mainCategoryRecycler!!.adapter = mainRecycler

    }

}