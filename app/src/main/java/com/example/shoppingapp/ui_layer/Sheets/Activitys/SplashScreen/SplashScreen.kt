package com.example.shoppingapp.ui_layer.Sheets.Activitys.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.shoppingapp.databinding.ActivitySplashScreenBinding
import com.example.shoppingapp.ui_layer.Sheets.Activitys.HomeActivity.HomeActivity
import com.example.shoppingapp.ui_layer.Sheets.Activitys.Login.LoginActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class SplashScreen : AppCompatActivity() {
    val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Handler(Looper.getMainLooper()).postDelayed({
            if (Firebase.auth.currentUser == null) {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        }, 500)
    }
}