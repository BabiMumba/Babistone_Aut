package com.example.babistone_auth.adapteur

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.babistone_auth.R
import com.example.babistone_auth.model.allcategories

class MainRecycler(private val context: Context, private val allcategories: List<allcategories>):

    RecyclerView.Adapter<MainRecycler.MainViewHolder>() {
    class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

      private  var category_title: TextView? = null
       init {
           category_title = itemView.findViewById(R.id.title_text)
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_recycler_row_item,parent,false))

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return allcategories.size
    }
}