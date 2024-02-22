package com.example.shoppingapp.ui_layer.Sheets.Activitys.AllProduct

import android.app.Activity
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import com.example.shoppingapp.Comman.PRODUCT_PATH
import com.example.shoppingapp.Comman.Products
import com.example.shoppingapp.R
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class AllProductViewModel(var activity: Activity) : ViewModel() {

    fun getAllData(function: (productList: ArrayList<Products>) -> Unit) {
        val tempList = ArrayList<Products>()
        Firebase.firestore.collection(PRODUCT_PATH)
            .get().addOnSuccessListener {
                val loader = activity.findViewById<ProgressBar?>(R.id.loaderAllProduct)
                loader?.visibility = View.GONE
                tempList.clear()
                for (i in it.documents) {
                    val tempProduct = i.toObject<Products>()
                    tempProduct?.productCode = i.id
                    tempList.add(tempProduct!!)
                }
                function(tempList)
            }
    }
}