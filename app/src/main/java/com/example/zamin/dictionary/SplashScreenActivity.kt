package com.example.zamin.dictionary

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.zamin.dictionary.need.D
import com.example.zamin.dictionary.need.SharePereferenseHelper
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SplashScreenActivity : AppCompatActivity() {
    private var dataBase: DatabaseReference = Firebase.database.reference
    private lateinit var sharePereferenseHelper: SharePereferenseHelper
    private lateinit var view: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val imageView: ImageView = findViewById(R.id.imageView)
        window.statusBarColor = Color.parseColor("#f9fef8")
        Glide.with(this).load(R.drawable.aa).into(imageView)
        sharePereferenseHelper = SharePereferenseHelper(this)
        view = findViewById(R.id.view)
        view.setOnLongClickListener {
                if (sharePereferenseHelper.get()=="false")
                {
                    dataBase.child("dictionaty").setValue("true")
                }else
                {
                    dataBase.child("dictionaty").setValue("false")
                }

            true
        }
        object : CountDownTimer(3000, 3000) {
            override fun onTick(p0: Long) {
            }
            override fun onFinish() {
                        startActivity(Intent(this@SplashScreenActivity,MainActivity::class.java))
                        finish()
            }
        }.start()
    }
}