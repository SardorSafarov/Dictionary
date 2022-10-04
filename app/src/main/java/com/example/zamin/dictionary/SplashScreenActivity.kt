package com.example.zamin.dictionary

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.zamin.dictionary.need.SharePereferenseHelper
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SplashScreenActivity : AppCompatActivity() {
    private var dataBase: DatabaseReference = Firebase.database.reference
    private lateinit var sharePereferenseHelper: SharePereferenseHelper
    private lateinit var view: View
    @SuppressLint("SuspiciousIndentation", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val imageView: ImageView = findViewById(R.id.imageView)
        window.statusBarColor = Color.parseColor("#ffffff")
        sharePereferenseHelper = SharePereferenseHelper(this)
        view = findViewById(R.id.view)
        view.setOnLongClickListener {
            if (sharePereferenseHelper.get() == "false") {
                dataBase.child("dictionaty").setValue("true")
            } else {
                dataBase.child("dictionaty").setValue("false")
            }

            true
        }

//        val videoView: VideoView = findViewById<VideoView>(R.id.imageView)
//        val mediaController = MediaController(this)
//        mediaController.setAnchorView(videoView)
//        val offlineUri = Uri.parse("android.resource://$packageName/${R.raw.splash}")
//                    videoView.setMediaController (mediaController)
//                    videoView.setVideoURI (offlineUri)
//                    videoView.requestFocus ()
//                    videoView.start ()
//
            object : CountDownTimer(2000, 2000) {
                override fun onTick(p0: Long) {
                }

                override fun onFinish() {
                    startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                    finish()
                }
            }.start()
        }
}