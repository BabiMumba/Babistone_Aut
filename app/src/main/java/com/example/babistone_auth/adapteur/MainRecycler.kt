package com.example.babistone_auth.adapteur

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.babistone_auth.R
import com.example.babistone_auth.model.allcategories

class MainRecycler(private val context: Context, private val allcategories: List<allcategories>):
    RecyclerView.Adapter<MainRecycler.MainViewHolder>() {
    class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_main))
    }

    override fun getItemCount(): Int {
        return allcategories.size
    }
}