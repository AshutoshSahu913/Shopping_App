package com.example.shoppingapp.ui_layer.Sheets.Activitys.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.ActivityLoginBinding
import com.example.shoppingapp.ui_layer.Sheets.Activitys.Home.HomeActivity
import com.example.shoppingapp.ui_layer.Sheets.Activitys.SignUp.SignUpActivity


class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    private lateinit var email: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            email = binding.inputEmail.text.toString().trim()
            password = binding.inputPassword.text.toString().trim()

            binding.inputEmail.setBackgroundResource(R.drawable.edit_text_shape)
            binding.inputPassword.setBackgroundResource(R.drawable.edit_text_shape)
            if (!(email.isBlank() || password.isBlank())) {
                startActivity(Intent(this, HomeActivity::class.java))
                Toast.makeText(this, "Login Successfully!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                if (email.isBlank()) {
                    binding.inputEmail.requestFocus()
                    binding.inputEmail.setBackgroundResource(R.drawable.edit_text_shape_error)
                }
                if (password.isBlank()) {
                    binding.inputPassword.setBackgroundResource(R.drawable.edit_text_shape_error)
                }
                Toast.makeText(this, "Please fill all the details !", Toast.LENGTH_SHORT).show()
            }
        }

        binding.goToSignUpBtn.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            Toast.makeText(this, "You are in Sign up Mode!", Toast.LENGTH_SHORT).show()

        }

        binding.googleBtn.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            Toast.makeText(this, "Google login Successfully!", Toast.LENGTH_SHORT).show()
            finish()
        }
        binding.facebookBtn.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            Toast.makeText(this, "Facebook login Successfully!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}