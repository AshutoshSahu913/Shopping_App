package com.example.shoppingapp.ui_layer.Sheets.Activitys.ProductDetails

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppingapp.Comman.ProductColor

class ProductDetailsViewModel(var context: Context) : ViewModel() {

    private val _productName = MutableLiveData<String>()
    val productName: LiveData<String> = _productName

    private val _productPrice = MutableLiveData<String>()
    val productPrice: LiveData<String> = _productPrice

    private val _productImg = MutableLiveData<String>()
    val productImg: LiveData<String> = _productImg


    private val _productDescription = MutableLiveData<String>()
    val productDescription: LiveData<String> = _productDescription

    private val _productDis = MutableLiveData<String>()
    val productDis: LiveData<String> = _productDis

    private val _productCode = MutableLiveData<String>()
    val productCode: LiveData<String> = _productCode

    private val _productImages = MutableLiveData<ArrayList<String>>()
    val productImages: LiveData<ArrayList<String>> = _productImages

    private val _productColors = MutableLiveData<List<ProductColor>>()
    val productColors: LiveData<List<ProductColor>> = _productColors

    private val _productSizes = MutableLiveData<ArrayList<String>>()
    val productSizes: LiveData<ArrayList<String>> = _productSizes

    fun setProductDetails(
        name: String,
        price: String,
        image: String,
        discount:String,
        code:String,
        description: String,
        images: ArrayList<String>,
        colors: List<ProductColor>,
        sizes:ArrayList<String>
    ) {
        _productName.value = name
        _productPrice.value = price
        _productImg.value = image
        _productDis.value=discount
        _productCode.value=code
        _productDescription.value = description
        _productImages.value = images
        _productColors.value = colors
        _productSizes.value=sizes
    }
}