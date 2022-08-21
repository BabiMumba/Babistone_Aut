package com.example.babistone_auth.adapteur

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.babistone_auth.model.library

class DataAdapter(private val liste_book:ArrayList<library>):RecyclerView.Adapter<DataAdapter.MyviewHolde>() {
    class MyviewHolde(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.MyviewHolde {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: DataAdapter.MyviewHolde, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}