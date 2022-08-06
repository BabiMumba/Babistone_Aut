package com.example.babistone_auth.adapteur

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.babistone_auth.R
import com.example.babistone_auth.model.fashio_model
import kotlinx.android.synthetic.main.row_item.view.*

class HorienzotaleAdapteur( var context: Context, var fashioModel: ArrayList<fashio_model>):
    RecyclerView.Adapter<HorienzotaleAdapteur.MyviewHolder>() {

    class MyviewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

         var nom:TextView
         var prix:TextView
         var image:ImageView
        init {
            nom = itemView.findViewById(R.id.nom_article)
            prix = itemView.findViewById(R.id.prix)
            image = itemView.findViewById(R.id.image_article)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)
        return  MyviewHolder(view)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val fashion = fashioModel[position]
        holder.prix.text = fashion.prix.toString()
        holder.nom.text = fashion.nom.toString()
        holder.image.setImageResource(fashion.image)


    }
    override fun getItemCount(): Int {
        return fashioModel.size
    }



}