package com.example.shoppingapp.ui_layer.Sheets.Activitys.SignUp

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModel
import com.example.shoppingapp.R
import com.example.shoppingapp.ui_layer.Sheets.Activitys.Home.HomeActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

//@SuppressLint("StaticFieldLeak")
class SignUpActivityViewModel(private var activity: Activity) : ViewModel() {

    fun signUp(email: String, password: String) {
        Firebase.auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val loader = activity.findViewById<ProgressBar>(R.id.loader)
                    loader.visibility = View.GONE
                    showDialog()
//                    Toast.makeText(
//                        activity, "Sign up successfully !", Toast.LENGTH_SHORT
//                    ).show()
                } else {
                    Toast.makeText(
                        activity, it.exception?.localizedMessage, Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    private fun showDialog() {
        // Create a dialog
        val dialog = Dialog(activity)
//        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        // Set the content view of the dialog
        dialog.setContentView(R.layout.success_register_dailog)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        /*
                val lp = WindowManager.LayoutParams()
                lp.width = WindowManager.LayoutParams.WRAP_CONTENT
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT
                if (Build.VERSION_CODES.S <= Build.VERSION.SDK_INT) {
                    lp.blurBehindRadius = 16
                }
                lp.flags = WindowManager.LayoutParams.FLAG_BLUR_BEHIND

                dialog.window?.attributes = lp
                dialog.setCancelable(false)
        */


        val btn = dialog.findViewById<AppCompatButton>(R.id.doneBtn)

        btn.setOnClickListener {
            val intent = Intent(activity, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            activity.startActivity(intent)
            activity.finish()

            Toast.makeText(
                activity, "Sign up & Login Successfully!", Toast.LENGTH_SHORT
            ).show()

        }
        // Show the dialog
        dialog.show()
    }
}