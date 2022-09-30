package com.example.zamin.dictionary

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.zamin.dictionary.databinding.ActivityPage2Binding
import com.example.zamin.dictionary.need.D

class Page2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityPage2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        binding = ActivityPage2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.title.text = intent.getStringExtra("title")
        binding.subTitile.text = intent.getStringExtra("subtitile")
        binding.body.text = intent.getStringExtra("body")
        binding.icBack.setOnClickListener {
            finish()
        }
    }
}