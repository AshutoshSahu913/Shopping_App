package com.example.shoppingapp.ui_layer.Sheets.Activitys.ProductDetails

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import coil.load
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.ActivityProductDetailsBinding
import com.example.shoppingapp.ui_layer.Sheets.Activitys.CheckOut.CheckOutActivity


class ProductDetailsActivity : AppCompatActivity() {
    val binding: ActivityProductDetailsBinding by lazy {
        ActivityProductDetailsBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = intent
        val itemName = intent.getStringExtra("name")
        val itemPrice = intent.getLongExtra("price",0)
        val itemImg = intent.getIntExtra("img", 0)
//        val itemDis = intent.getStringExtra("discount")
//        val itemCode = intent.getStringExtra("code")

//        val itemColor = intent.getIntExtra("color", 0)


        with(binding) {
            productDetailsName.text = itemName
            productDetailsPrice.text = itemPrice.toString()
            productDetailsImg.load(itemImg) {
                placeholder(R.drawable.placeholder)
            }
            productDetailsDescription.text =
                "$itemName\nRs :${itemPrice}\n${productDetailsDescription.text}"
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