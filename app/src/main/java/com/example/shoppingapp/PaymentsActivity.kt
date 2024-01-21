package com.example.shoppingapp

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.widget.AppCompatButton
import com.example.shoppingapp.databinding.ActivityPaymentsBinding

class PaymentsActivity : AppCompatActivity() {
    val binding: ActivityPaymentsBinding by lazy {
        ActivityPaymentsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.payNowBtn.setOnClickListener {
            // Create a dialog
            val dialog = Dialog(this)
            // Set the content view of the dialog
            dialog.setContentView(R.layout.success_payment_dailog)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            var btn = dialog.findViewById<AppCompatButton>(R.id.startShoppingBtn)
            btn.setOnClickListener {
                startActivity(Intent(this@PaymentsActivity, HomeActivity::class.java))
            }


            // Show the dialog
            dialog.show()
        }


    }
}