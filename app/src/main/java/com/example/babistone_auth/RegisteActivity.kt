package com.example.babistone_auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.ActionBar
import com.example.babistone_auth.databinding.ActivityRegisteBinding

class RegisteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegisteBinding
    private lateinit var actionBar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}