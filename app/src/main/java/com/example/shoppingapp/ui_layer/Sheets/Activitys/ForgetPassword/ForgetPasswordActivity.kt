package com.example.shoppingapp.ui_layer.Sheets.Activitys.ForgetPassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.ActivityForgetPasswordBinding

class ForgetPasswordActivity : AppCompatActivity() {
    val binding:ActivityForgetPasswordBinding by lazy {
        ActivityForgetPasswordBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {

        }
    }
}