package com.example.babistone_auth.adapteur

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.babistone_auth.R

class HorienzotaleAdapteur: RecyclerView.Adapter<HorienzotaleAdapteur.MyviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }

    class MyviewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }


}