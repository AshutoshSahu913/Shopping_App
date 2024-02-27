package com.example.shoppingapp.Comman

import android.widget.EditText


const val PRODUCT_IMAGE_FOLDER_PATH = "Product_images"
const val PRODUCT_DISPLAY_IMAGES_FOLDER_PATH = "Product_Display_images"
const val PRODUCT_PATH = "Product_path"
const val PRODUCT_WISHLIST_PATH = "Wishlist_path"



fun returnText(view: EditText): String {
    return view.text.toString().trim()
}
