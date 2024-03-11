package com.example.shoppingapp.ui_layer.Sheets.Fragments.Cart

import android.app.Activity
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.shoppingapp.Comman.PRODUCT_CART_PATH
import com.example.shoppingapp.Comman.Products
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class CartFragmentViewModel(var activity: Activity) : ViewModel() {
    fun getDataFromCartList(function: (cartList: ArrayList<Products>) -> Unit) {
        val tempList = ArrayList<Products>()
        Firebase.firestore.collection(PRODUCT_CART_PATH)
            .get().addOnSuccessListener {
//                val loader = activity.findViewById<ProgressBar>(R.id.loaderWishlist)
//                loader?.visibility = View.GONE
                tempList.clear()
                for (i in it.documents) {
                    Toast.makeText(activity, "${it.size()}", Toast.LENGTH_SHORT).show()
                    val tempProduct = i.toObject<Products>()
                    tempList.add(tempProduct!!)
                }
                function(tempList)
            }
    }
}