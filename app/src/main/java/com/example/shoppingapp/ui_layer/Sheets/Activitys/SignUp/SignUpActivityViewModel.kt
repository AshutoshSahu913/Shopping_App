package com.example.shoppingapp.ui_layer.Sheets.Activitys.SignUp

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Build
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModel
import com.example.shoppingapp.R
import com.example.shoppingapp.ui_layer.Sheets.Activitys.Home.HomeActivity

class SignUpActivityViewModel(var activity: Activity) : ViewModel() {


    fun showDialog() {
        // Create a dialog
        val dialog = Dialog(activity)
//        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        // Set the content view of the dialog
        dialog.setContentView(R.layout.success_register_dailog)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val lp = WindowManager.LayoutParams()
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        if (Build.VERSION_CODES.S <= Build.VERSION.SDK_INT) {
            lp.blurBehindRadius = 16
        }
        lp.flags = WindowManager.LayoutParams.FLAG_BLUR_BEHIND

        dialog.window?.attributes=lp
        dialog.setCancelable(false)
        // Show the dialog
        dialog.show()



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
    }
}