package com.example.shoppingapp.Comman

data class Products(
    var productCode: String? = null,
    var productDisplayImage: String? = null,
    var productDisplayImages: ArrayList<String>? = arrayListOf(),
    var productName: String? = null,
    var productDes: String? = null,
    var productPrice: Long? = null,
    var productDiscountPercent: Long? = null,
    var productSize: ArrayList<String>? = arrayListOf(),
    var productColor: List<ProductColor>? = null
)

data class ProductColor(var colorName: String? = null, var colorCode: Int? = null)