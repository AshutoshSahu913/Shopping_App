package com.example.shoppingapp

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.shoppingapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private val binding: ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

    private lateinit var firstName: String
    private lateinit var lastName: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var confirmPassword: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {

            signUpBtn.setOnClickListener {

                firstName = inputFirstName.text.toString().trim()
                lastName = inputLastName.text.toString().trim()
                email = inputEmail.text.toString().trim()
                password = inputPassword.text.toString().trim()
                confirmPassword = inputConfirmPassword.text.toString().trim()

                inputFirstName.setBackgroundResource(R.drawable.edit_text_shape)
                inputEmail.setBackgroundResource(R.drawable.edit_text_shape)
                inputPassword.setBackgroundResource(R.drawable.edit_text_shape)
                inputConfirmPassword.setBackgroundResource(R.drawable.edit_text_shape)

                if (firstName.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                    if (firstName.isBlank()) {
                        inputFirstName.setBackgroundResource(R.drawable.edit_text_shape_error)
                    }
                    if (email.isBlank()) {
                        inputEmail.setBackgroundResource(R.drawable.edit_text_shape_error)
                    }
                    if (password.isBlank()) {
                        inputPassword.setBackgroundResource(R.drawable.edit_text_shape_error)
                    }
                    if (confirmPassword.isBlank()) {

                        inputConfirmPassword.setBackgroundResource(R.drawable.edit_text_shape_error)
                    }
                    Toast.makeText(
                        this@SignUpActivity, "Please fill all the details!", Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // Create a dialog
                    val dialog = Dialog(this@SignUpActivity)
                    dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                    // Set the content view of the dialog
                    dialog.setContentView(R.layout.success_register_dailog)
                    dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

                    var btn = dialog.findViewById<AppCompatButton>(R.id.doneBtn)

                    btn.setOnClickListener {
                        startActivity(Intent(this@SignUpActivity, HomeActivity::class.java))
                        Toast.makeText(
                            this@SignUpActivity, "Sign up & Login Successfully!", Toast.LENGTH_SHORT
                        ).show()
                    }
                    // Show the dialog
                    dialog.show()
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