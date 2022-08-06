package com.example.babistone_auth.adapteur

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.babistone_auth.R
import com.example.babistone_auth.model.fashio_model
import kotlinx.android.synthetic.main.row_item.view.*

class HorienzotaleAdapteur( var context: Context, var fashioModel: ArrayList<fashio_model>):
    RecyclerView.Adapter<HorienzotaleAdapteur.MyviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)
        return  MyviewHolder(view)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

    }
    override fun getItemCount(): Int {
        return fashioModel.size
    }
    class MyviewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun binItem(fashioModel: fashio_model){
            itemView.nom_article.text = fashioModel.nom
            itemView.prix.text = fashioModel.prix.toString()
            itemView.image_article.setImageResource(fashioModel.image)


        }

    }


}