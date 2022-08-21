package com.example.babistone_auth.adapteur

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.babistone_auth.R
import com.example.babistone_auth.model.library

class DataAdapter(private val liste_book:ArrayList<library>):RecyclerView.Adapter<DataAdapter.MyviewHolde>() {
    class MyviewHolde(itemView: View):RecyclerView.ViewHolder(itemView) {
        val name_book:TextView = itemView.findViewById(R.id.name_bk)
        val name_autor:TextView = itemView.findViewById(R.id.name_aut)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.MyviewHolde {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.row_item_data,parent,false)
        return MyviewHolde(itemview)
    }

    override fun onBindViewHolder(holder: DataAdapter.MyviewHolde, position: Int) {
        val library:library = liste_book[position]
        holder.name_book.text = library.name_book
        holder.name_autor.text = library.name_autor
    }

    override fun getItemCount(): Int {
        liste_book.size
    }
}