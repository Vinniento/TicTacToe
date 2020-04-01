package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        startActivity(Intent(this, MainActivity::class.java))

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}
