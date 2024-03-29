package com.example.shoppingapp.ui_layer.Sheets.Fragments.Home

import android.app.Activity
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppingapp.Comman.PRODUCT_PATH
import com.example.shoppingapp.Comman.Products
import com.example.shoppingapp.R
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class HomeFragmentViewModel(var activity: Activity) : ViewModel() {

    fun getTop5Data(function: (productList: ArrayList<Products>) -> Unit) {
        val tempList = ArrayList<Products>()
        Firebase.firestore.collection(PRODUCT_PATH).limit(5)
            .get().addOnSuccessListener {
                val loader = activity.findViewById<ProgressBar?>(R.id.loaderHome)
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