package com.example.shoppingapp.ui_layer.Sheets.Fragments.WishList

import android.app.Activity
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.shoppingapp.Comman.PRODUCT_WISHLIST_PATH
import com.example.shoppingapp.Comman.Products
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase

class WishListFragmentViewModel(var activity: Activity) : ViewModel() {
    fun getDataFromWishlist(function: (wishList: ArrayList<Products>) -> Unit) {
        val tempList = ArrayList<Products>()
        Firebase.firestore.collection(PRODUCT_WISHLIST_PATH)
            .get().addOnSuccessListener {
//                val loader = activity.findViewById<ProgressBar>(R.id.loaderProduct)
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