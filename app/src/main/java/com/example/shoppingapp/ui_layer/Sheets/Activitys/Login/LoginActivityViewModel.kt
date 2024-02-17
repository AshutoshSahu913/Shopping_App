package com.example.shoppingapp.ui_layer.Sheets.Activitys.Login

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.shoppingapp.ui_layer.Sheets.Activitys.Home.HomeActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginActivityViewModel(var activity: Activity) : ViewModel() {
    fun loginUser(email: String, password: String) {
        Firebase.auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    activity.startActivity(Intent(activity, HomeActivity::class.java))
                    Toast.makeText(activity, "Login Successfully!", Toast.LENGTH_SHORT).show()
                    activity.finish()
                } else {
                    Toast.makeText(activity, it.exception?.localizedMessage, Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }
}