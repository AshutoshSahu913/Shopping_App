package com.example.shoppingapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.shoppingapp.Fragments.CartFragment
import com.example.shoppingapp.Fragments.WishListFragment
import com.example.shoppingapp.databinding.ActivityProductDetailsBinding


class productDetailsActivity : AppCompatActivity() {
    val binding: ActivityProductDetailsBinding by lazy {
        ActivityProductDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val itemName = intent.getStringExtra("name")
        val itemPrice = intent.getStringExtra("price")
        val itemImg = intent.getIntExtra("img", 0)
//        val itemDis = intent.getStringExtra("discount")
//        val itemCode = intent.getStringExtra("code")
//        val itemColor = intent.getStringExtra("color")


        with(binding) {
            productDetailsName.text = itemName
            productDetailsPrice.text = itemPrice
            productDetailsImg.setImageResource(itemImg)
//            Glide.with(this@productDetailsActivity).load(Uri.parse(itemImg)).into(productDetailsImg)


        }
        binding.backBtn.setOnClickListener {
            finish()
        }
        binding.addToCartBtn.setOnClickListener {
            binding.addToCartBtn.text = "Added to cart"
            Toast.makeText(this, "Added to Cart", Toast.LENGTH_SHORT).show()
        }

        binding.addToWishList.setOnClickListener {
            Toast.makeText(this, "Added to WishList", Toast.LENGTH_SHORT).show()
        }
        binding.buyNowBtn.setOnClickListener {
            Toast.makeText(this, "Buy Now", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@productDetailsActivity, CheckOutActivity::class.java))
        }
    }
}