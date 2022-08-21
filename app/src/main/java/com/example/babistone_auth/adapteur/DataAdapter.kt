package com.example.babistone_auth.adapteur

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.babistone_auth.R
import com.example.babistone_auth.model.library

class DataAdapter(private val liste_book:ArrayList<library>):RecyclerView.Adapter<DataAdapter.MyviewHolde>() {

    public class MyviewHolde(itemView: View):RecyclerView.ViewHolder(itemView) {
        val name_book:TextView
        val name_autor:TextView
        init {
            name_book = itemView.findViewById(R.id.name_bk)
            name_autor= itemView.findViewById(R.id.name_aut)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolde {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.row_item_data,parent,false)
        return MyviewHolde(itemview)
    }

    override fun onBindViewHolder(holder: MyviewHolde, position: Int) {
        val lbrary:library = liste_book[position]

        holder.name_book.text = lbrary.name_book.toString()
        holder.name_autor.text = lbrary.name_autor.toString()
        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return liste_book.size
    }
}