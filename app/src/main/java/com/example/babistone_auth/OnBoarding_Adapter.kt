package com.example.babistone_auth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnBoarding_Adapter(private val onboardindItem: List<OnBoardind_items>):RecyclerView.Adapter<OnBoarding_Adapter.OnBoardingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {

        return OnBoardingViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.on_boarding_items_contaoners
        ,parent,
            false
        )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {

        holder.bind(onboardindItem[position])
    }

    override fun getItemCount(): Int {
        return onboardindItem.size
    }

    inner class  OnBoardingViewHolder(view:View):RecyclerView.ViewHolder(view){
        private val imageonBoarding = view.findViewById<ImageView>(R.id.image_onboarding)
        private val texteTitle = view.findViewById<TextView>(R.id.text_title)
        private val text_descr= view.findViewById<TextView>(R.id.text_description)
        fun bind(onboardindItem: OnBoardind_items){
            imageonBoarding.setImageResource(onboardindItem.onboardingImage)
            texteTitle.text = onboardindItem.title
            text_descr.text = onboardindItem.description
        }
    }


}