package com.example.zamin.dictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zamin.dictionary.databinding.ActivityPage2Binding

class Page2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityPage2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPage2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.icBack.setOnClickListener {
            finish()
        }
    }
}