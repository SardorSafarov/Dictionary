package com.example.zamin.dictionary

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import com.bumptech.glide.Glide

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val imageView: ImageView = findViewById(R.id.imageView)
        window.statusBarColor = Color.parseColor("#f9fef8")
        Glide.with(this).load(R.drawable.aa).into(imageView)
        object :CountDownTimer(3000,3000){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
               startActivity(Intent(this@SplashScreenActivity,MainActivity::class.java))
                finish()
            }
        }.start()
    }
}