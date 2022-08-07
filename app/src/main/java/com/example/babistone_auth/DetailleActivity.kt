package com.example.babistone_auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.babistone_auth.R
import kotlinx.android.synthetic.main.activity_detaille.*

class DetailleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detaille)
        var intent = intent
        val ttr = intent.getIntExtra("image",R.drawable.pec)
        img_detaille.setImageResource(ttr)

    }
}