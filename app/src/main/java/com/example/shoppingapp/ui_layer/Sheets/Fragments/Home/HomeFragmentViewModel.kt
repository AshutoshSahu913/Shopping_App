package com.example.shoppingapp.ui_layer.Sheets.Fragments.Home

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppingapp.Comman.PRODUCT_PATH
import com.example.shoppingapp.Comman.Products
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class HomeFragmentViewModel(var activity: Activity) : ViewModel() {

    lateinit var top5Products: ArrayList<Products>

    //        MutableLiveData(arrayListOf<Products?>())
//    val productList = ArrayList<Products>()
////
//    init {
//        getTop5Data()
//    }


    fun getTop5Data(function: (productList: ArrayList<Products>) -> Unit) {
        val tempList = ArrayList<Products>()
        Firebase.firestore.collection(PRODUCT_PATH)
            .get().addOnSuccessListener {

                tempList.clear()
                for (i in it.documents) {
                    val tempProduct = i.toObject<Products>()
                    tempList.add(tempProduct!!)
                }
                function(tempList)
            }
    }

}