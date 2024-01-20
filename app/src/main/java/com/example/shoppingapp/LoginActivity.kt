package com.example.shoppingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shoppingapp.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var email = binding.inputEmail.text.toString().trim()
        var password = binding.inputPassword.text.toString().trim()

        binding.loginBtn.setOnClickListener {
            binding.inputEmail.setBackgroundResource(R.drawable.edit_text_shape)
            binding.inputPassword.setBackgroundResource(R.drawable.edit_text_shape)
            if ((email.isEmpty() && password.isEmpty())) {
                startActivity(Intent(this, HomeActivity::class.java))
                Toast.makeText(this, "Login Successfully!", Toast.LENGTH_SHORT).show()
            } else {
                if (email.isEmpty()) {
                    binding.inputEmail.requestFocus()
                    binding.inputEmail.setBackgroundResource(R.drawable.edit_text_shape_error)
                }
                if (password.isEmpty()) {
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
        }
        binding.facebookBtn.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            Toast.makeText(this, "Facebook login Successfully!", Toast.LENGTH_SHORT).show()
        }
    }
}