package com.example.shoppingapp.ui_layer.Sheets.Activitys.SignUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingapp.Comman.returnText
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.ActivitySignUpBinding
import com.example.shoppingapp.ui_layer.Sheets.Activitys.HomeActivity.HomeActivity
import com.example.shoppingapp.ui_layer.Sheets.Activitys.Login.LoginActivity
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.Circle

class SignUpActivity : AppCompatActivity() {
    private val binding: ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

//    private lateinit var firstName: String
//    private lateinit var lastName: String
//    private lateinit var email: String
//    private lateinit var password: String
//    private lateinit var confirmPassword: String


    private val signUpActivityViewModel by viewModels<SignUpActivityViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return SignUpActivityViewModel(this@SignUpActivity) as T
                }
            }
        }
    )

    //    val viewModel = ViewModelProvider(this)[SignUpActivityViewModel::class.java]
    fun loader() {
        // code for loader
        val progressBar = binding.loader as ProgressBar
        val circle: Sprite = Circle()
        progressBar.indeterminateDrawable = circle
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {

            signUpBtn.setOnClickListener {
                loader()
//                firstName = inputFirstName.text.toString().trim()
//                lastName = inputLastName.text.toString().trim()
//                email = inputEmail.text.toString().trim()
//                password = inputPassword.text.toString().trim()
//                confirmPassword = inputConfirmPassword.text.toString().trim()

                inputFirstName.setBackgroundResource(R.drawable.edit_text_shape)
                inputEmail.setBackgroundResource(R.drawable.edit_text_shape)
                inputPassword.setBackgroundResource(R.drawable.edit_text_shape)
                inputConfirmPassword.setBackgroundResource(R.drawable.edit_text_shape)

                if (returnText(inputEmail).isBlank() || returnText(inputPassword).isBlank() || returnText(
                        inputConfirmPassword
                    ).isBlank()
                ) {
//                    if (firstName.isBlank()) {
//                        inputFirstName.setBackgroundResource(R.drawable.edit_text_shape_error)
//                    }
                    if (returnText(inputEmail).isBlank()) {
                        inputEmail.setBackgroundResource(R.drawable.edit_text_shape_error)
                    }
                    if (returnText(inputPassword).isBlank()) {
                        inputPassword.setBackgroundResource(R.drawable.edit_text_shape_error)
                    }
                    if (returnText(inputConfirmPassword).isBlank()) {
                        inputConfirmPassword.setBackgroundResource(R.drawable.edit_text_shape_error)
                    }
                    Toast.makeText(
                        this@SignUpActivity, "Please fill all the details!", Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (inputPassword.text.toString() == inputConfirmPassword.text.toString()) {
                        loader.visibility = View.VISIBLE
                        signUpActivityViewModel.signUp(
                            returnText(inputEmail),
                            returnText(inputConfirmPassword)
                        )
                        loader.visibility = View.GONE

                    } else {
                        inputPassword.setBackgroundResource(R.drawable.edit_text_shape_error)
                        inputConfirmPassword.setBackgroundResource(R.drawable.edit_text_shape_error)
                        Toast.makeText(
                            this@SignUpActivity, "Password don't not Match !", Toast.LENGTH_SHORT
                        ).show()
                    }

                }
            }

            goToLoginBtn.setOnClickListener {
                startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
            }

            googleBtn.setOnClickListener {
                startActivity(Intent(this@SignUpActivity, HomeActivity::class.java))
                Toast.makeText(
                    this@SignUpActivity, "Sign up with Google Successfully!", Toast.LENGTH_SHORT
                ).show()
            }
            facebookBtn.setOnClickListener {
                startActivity(Intent(this@SignUpActivity, HomeActivity::class.java))
                Toast.makeText(
                    this@SignUpActivity, "Sign up with Facebook Successfully!", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}