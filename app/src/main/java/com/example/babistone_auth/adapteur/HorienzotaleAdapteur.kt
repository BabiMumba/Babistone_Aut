package com.example.babistone_auth.adapteur

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.babistone_auth.R
import com.example.babistone_auth.model.fashio_model

class HorienzotaleAdapteur(private var context: Context,private var fashioModel: ArrayList<fashio_model>):
    RecyclerView.Adapter<HorienzotaleAdapteur.MyviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)
        return  MyviewHolder(view)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

    }
    override fun getItemCount(): Int {
        return 30
    }
    class MyviewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    }


}