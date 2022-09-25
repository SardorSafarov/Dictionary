package com.example.zamin.dictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zamin.dictionary.databinding.ActivityPage1Binding

class Page1Activity : AppCompatActivity() {
    private lateinit var binding:ActivityPage1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPage1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.icBack.setOnClickListener {
            finish()
        }
    }
}