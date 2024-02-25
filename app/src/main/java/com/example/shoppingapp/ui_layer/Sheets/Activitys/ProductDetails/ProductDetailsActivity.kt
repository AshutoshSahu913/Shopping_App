package com.example.shoppingapp.ui_layer.Sheets.Activitys.ProductDetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import coil.load
import com.example.shoppingapp.Comman.ProductColor
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.ActivityProductDetailsBinding
import com.example.shoppingapp.ui_layer.Adapter.ProductColorAdapter
import com.example.shoppingapp.ui_layer.Adapter.ProductImagesAdapter
import com.example.shoppingapp.ui_layer.Sheets.Activitys.CheckOut.CheckOutActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ProductDetailsActivity : AppCompatActivity() {
    val binding: ActivityProductDetailsBinding by lazy {
        ActivityProductDetailsBinding.inflate(layoutInflater)
    }

    lateinit var productImageAdapter: ProductImagesAdapter
//    lateinit var productColorAdapter: ProductColorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = intent
        val itemName = intent.getStringExtra("name")
        val itemPrice = intent.getStringExtra("price")
        val itemImg = intent.getStringExtra("img")
        val itemDes = intent.getStringExtra("description")
        val itemSizes = intent.getStringArrayListExtra("sizes")
        val itemImages = intent.getStringArrayListExtra("images")
        val itemColorJson = intent.getStringExtra("color")



        with(binding) {
            productDetailsName.text = itemName.toString()
            productDetailsPrice.text = itemPrice.toString()
            productDetailsImg.load(itemImg) {
                placeholder(R.drawable.placeholder)
            }
            productDetailsDescription.text =
                itemDes.toString()


            productImageAdapter =
                itemImages?.let { ProductImagesAdapter(it, this@ProductDetailsActivity) }!!
            binding.rvProductImages.adapter = productImageAdapter


            // Deserialize product color data
//            val productColorListType = object : TypeToken<List<ProductColor>>() {}.type
//            val productColors: List<ProductColor> =
//                Gson().fromJson(itemColorJson, productColorListType)
//            // Set up product colors RecyclerView
//            productColorAdapter = ProductColorAdapter(productColors, this@ProductDetailsActivity)
//            rvColors.adapter = productColorAdapter
        }

        binding.backBtn.setOnClickListener {
            finish()
        }
        binding.addToCartBtn.setOnClickListener {
            binding.addToCartBtn.text = "Added to cart"
            Toast.makeText(this, "Added to Cart", Toast.LENGTH_SHORT).show()
        }

        binding.addToWishList.setOnClickListener {
            binding.like.setBackgroundResource(R.drawable.baseline_favorite_24)
            binding.addToWishListTxt.text = "Added to WishList"
            Toast.makeText(this, "Added to WishList", Toast.LENGTH_SHORT).show()
        }
        binding.buyNowBtn.setOnClickListener {
            Toast.makeText(this, "Buy Now", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@ProductDetailsActivity, CheckOutActivity::class.java))
        }
    }
}