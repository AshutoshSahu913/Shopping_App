package com.example.shoppingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shoppingapp.databinding.ActivityCheckOutBinding

class CheckOutActivity : AppCompatActivity() {
    val binding: ActivityCheckOutBinding by lazy {
        ActivityCheckOutBinding.inflate(layoutInflater)
    }

    lateinit var email: String
    lateinit var country: String
    lateinit var firstName: String
    lateinit var lastName: String
    lateinit var address: String
    lateinit var city: String
    lateinit var postalCode: String
    lateinit var contactNo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {

            email = inputEmail.text.toString().trim()
            country = inputCountry.text.toString().trim()
            firstName = inputFirstName.text.toString().trim()
            lastName = inputLastName.text.toString().trim()
            address = inputAddress.text.toString().trim()
            city = inputCity.text.toString().trim()
            postalCode = inputPostalCode.text.toString().trim()
            contactNo = inputContactNumber.text.toString().trim()



            backBtn.setOnClickListener {
                finish()
            }
            continueShippingBtn.setOnClickListener {
                inputEmail.setBackgroundResource(R.drawable.edit_text_shape)
                inputFirstName.setBackgroundResource(R.drawable.edit_text_shape)
                inputAddress.setBackgroundResource(R.drawable.edit_text_shape)
                inputPostalCode.setBackgroundResource(R.drawable.edit_text_shape)
                inputContactNumber.setBackgroundResource(R.drawable.edit_text_shape)


                if ((email.isBlank() || firstName.isBlank() || address.isBlank() || postalCode.isBlank() || contactNo.isBlank())) {
                    startActivity(Intent(this@CheckOutActivity, PaymentsActivity::class.java))
                    Toast.makeText(this@CheckOutActivity, "Continue Shipping", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(
                        this@CheckOutActivity,
                        "Please fill all the fields",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    if (email.isBlank()) {
                        inputEmail.setBackgroundResource(R.drawable.edit_text_shape_error)
                    }
                    if (firstName.isBlank()) {
                        inputFirstName.setBackgroundResource(R.drawable.edit_text_shape_error)
                    }
                    if (address.isBlank()) {
                        inputAddress.setBackgroundResource(R.drawable.edit_text_shape_error)
                    }
                    if (postalCode.isBlank()) {
                        inputPostalCode.setBackgroundResource(R.drawable.edit_text_shape_error)
                    }
                    if (contactNo.isBlank()) {
                        inputContactNumber.setBackgroundResource(R.drawable.edit_text_shape_error)
                    }

                }


            }

        }


    }
}