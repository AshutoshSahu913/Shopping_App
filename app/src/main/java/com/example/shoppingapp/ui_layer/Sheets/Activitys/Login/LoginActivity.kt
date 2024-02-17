package com.example.shoppingapp.ui_layer.Sheets.Activitys.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingapp.Comman.returnText
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.ActivityLoginBinding
import com.example.shoppingapp.ui_layer.Sheets.Activitys.HomeActivity.HomeActivity
import com.example.shoppingapp.ui_layer.Sheets.Activitys.SignUp.SignUpActivity


class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

//    private lateinit var email: String
//    private lateinit var password: String

    val loginActivityViewModel by viewModels<LoginActivityViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return LoginActivityViewModel(this@LoginActivity) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {

            loginBtn.setOnClickListener {
//                email = binding.inputEmail.text.toString().trim()
//                password = binding.inputPassword.text.toString().trim()

                inputEmail.setBackgroundResource(R.drawable.edit_text_shape)
                inputPassword.setBackgroundResource(R.drawable.edit_text_shape)
                if (!(inputEmail.text.isBlank() || inputPassword.text.isBlank())) {
                    loginActivityViewModel.loginUser(
                        returnText(inputEmail),
                        returnText(inputPassword)
                    )
                } else {
                    if (inputEmail.text.isBlank()) {
                        inputEmail.requestFocus()
                        inputEmail.setBackgroundResource(R.drawable.edit_text_shape_error)
                    }
                    if (inputPassword.text.isBlank()) {
                        inputPassword.setBackgroundResource(R.drawable.edit_text_shape_error)
                    }
                    Toast.makeText(
                        this@LoginActivity,
                        "Please fill all the details !",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }


            goToSignUpBtn.setOnClickListener {
                startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
                Toast.makeText(this@LoginActivity, "You are in Sign up Mode!", Toast.LENGTH_SHORT).show()

            }

            googleBtn.setOnClickListener {
                startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                Toast.makeText(this@LoginActivity, "Google login Successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
            facebookBtn.setOnClickListener {
                startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                Toast.makeText(this@LoginActivity, "Facebook login Successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}