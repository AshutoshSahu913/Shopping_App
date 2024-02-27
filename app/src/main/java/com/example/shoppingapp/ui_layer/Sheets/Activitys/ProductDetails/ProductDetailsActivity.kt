package com.example.shoppingapp.ui_layer.Sheets.Activitys.ProductDetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.shoppingapp.Comman.PRODUCT_PATH
import com.example.shoppingapp.Comman.PRODUCT_WISHLIST_PATH
import com.example.shoppingapp.Comman.ProductColor
import com.example.shoppingapp.Comman.Products
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.ActivityProductDetailsBinding
import com.example.shoppingapp.ui_layer.Adapter.ProductColorAdapter
import com.example.shoppingapp.ui_layer.Adapter.ProductImagesAdapter
import com.example.shoppingapp.ui_layer.Adapter.ProductSizesAdapter
import com.example.shoppingapp.ui_layer.Sheets.Activitys.CheckOut.CheckOutActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ProductDetailsActivity : AppCompatActivity() {
    val binding: ActivityProductDetailsBinding by lazy {
        ActivityProductDetailsBinding.inflate(layoutInflater)
    }

    lateinit var productDetailsViewModel: ProductDetailsViewModel
    lateinit var productImageAdapter: ProductImagesAdapter
    lateinit var productColorAdapter: ProductColorAdapter
    lateinit var productSizesAdapter: ProductSizesAdapter
    private var quantity = 0
    val product = Products()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val _productDetailsViewModel by viewModels<ProductDetailsViewModel>(
            factoryProducer = {
                object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return ProductDetailsViewModel(this@ProductDetailsActivity) as T
                    }
                }
            }
        )
        productDetailsViewModel = _productDetailsViewModel
        productDetailsViewModel

        val intent = intent
        val itemName = intent.getStringExtra("name")
        val itemPrice = intent.getStringExtra("price")
        val itemImg = intent.getStringExtra("img")
        val itemDes = intent.getStringExtra("description")
        val itemSizes = intent.getStringArrayListExtra("sizes")
        val itemImages = intent.getStringArrayListExtra("images")
        val itemColorJson = intent.getStringExtra("productColorJson")
        val itemDiscount = intent.getStringExtra("discount")
        val itemCode = intent.getStringExtra("code")



        productDetailsViewModel.setProductDetails(
            itemName!!,
            itemPrice!!,
            itemImg!!,
            itemDiscount!!,
            itemCode!!,
            itemDes!!,
            itemImages!!,
            getColorsFromJson(itemColorJson),
            itemSizes!!
        )
        /*
                with(binding) {
                    productDetailsName.text = itemName.toString()
                    productDetailsPrice.text = itemPrice.toString()
                    productDetailsImg.load(itemImg) {
                        placeholder(R.drawable.placeholder)
                    }
                    productDetailsDescription.text =
                        itemDes.toString()

                    //set images to recycler view
                    productImageAdapter =
                        itemImages?.let { ProductImagesAdapter(it, this@ProductDetailsActivity) }!!
                    binding.rvProductImages.adapter = productImageAdapter

                    Toast.makeText(this@ProductDetailsActivity, "colorCode: ${itemColorJson.toString()}", Toast.LENGTH_SHORT).show()
                    // Deserialize product color data if JSON string is not null
                    if (itemColorJson != null) {
                        val productColorListType = object : TypeToken<List<ProductColor>>() {}.type
                        val productColors: List<ProductColor> = Gson().fromJson(itemColorJson, productColorListType)
                        // Set up product colors RecyclerView
                        productColorAdapter =
                            ProductColorAdapter(productColors, this@ProductDetailsActivity)
                        rvColors.adapter = productColorAdapter
                    }*/


        productDetailsViewModel.productName.observe(this, Observer {
            binding.productDetailsName.text = it
            product.productName = it.toString().trim()
        })

        productDetailsViewModel.productPrice.observe(this, Observer {
            binding.productDetailsPrice.text = it
            product.productPrice = it.toString().trim().toLong()
        })
        productDetailsViewModel.productDis.observe(this, Observer {
            product.productDiscountPercent = it.toString().toLong()
        })
        productDetailsViewModel.productCode.observe(this, Observer {
            binding.productDetailsCode.text = it.toString().trim()
            product.productCode = it.toString().trim()
        })

        productDetailsViewModel.productImg.observe(this, Observer {
            binding.productDetailsImg.load(it) {
                placeholder(R.drawable.placeholder)
            }
            product.productDisplayImage = it
        })
        productDetailsViewModel.productDescription.observe(this, Observer {
            binding.productDetailsDescription.text = it
            product.productDes = it.toString().trim()
        })

        productDetailsViewModel.productImages.observe(this, Observer {
            productImageAdapter = ProductImagesAdapter(it, this@ProductDetailsActivity)
            binding.rvProductImages.adapter = productImageAdapter
            product.productDisplayImages = it
        })

        productDetailsViewModel.productColors.observe(this, Observer {
            productColorAdapter = ProductColorAdapter(it, this@ProductDetailsActivity)
            binding.rvColors.adapter = productColorAdapter
            product.productColor = it
        })

        productDetailsViewModel.productSizes.observe(this, Observer {
            productSizesAdapter = ProductSizesAdapter(it, this@ProductDetailsActivity)
            binding.rvSizes.adapter = productSizesAdapter
            product.productSize = it
        })

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.addToCartBtn.setOnClickListener {
            binding.addToCartBtn.text = "Added to cart"
            binding.addToCartBtn.isEnabled = false
            Toast.makeText(this, "Added to Cart", Toast.LENGTH_SHORT).show()
        }

        binding.addToWishList.setOnClickListener {
            FirebaseFirestore.getInstance().collection(PRODUCT_WISHLIST_PATH).document()
                .set(product)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        binding.like.setBackgroundResource(R.drawable.baseline_favorite_24)
                        binding.addToWishListTxt.text = "Added to WishList"
                        binding.addToWishList.isEnabled = false
                        Toast.makeText(this, "Added to WishList", Toast.LENGTH_SHORT).show()

                        finish()

                    } else {
                        Toast.makeText(this, "Not", Toast.LENGTH_SHORT).show()

                    }
                }
        }
        binding.buyNowBtn.setBackgroundResource(R.drawable.back_btn)

        binding.buyNowBtn.setOnClickListener {
            Toast.makeText(this, "Buy Now", Toast.LENGTH_SHORT).show()
            binding.buyNowBtn.setBackgroundResource(R.drawable.back)
            startActivity(Intent(this@ProductDetailsActivity, CheckOutActivity::class.java))
        }


        // Initialize quantity display
        updateQuantityDisplay()

        // Increment quantity when plus button is clicked
        binding.plusBtn.setOnClickListener {
            quantity++
            updateQuantityDisplay()
        }

        // Decrement quantity when minus button is clicked
        binding.minusBtn.setOnClickListener {
            if (quantity > 0) {
                quantity--
                updateQuantityDisplay()
            }
        }
    }

    private fun updateQuantityDisplay() {
        binding.productDetailsItemQty.text = quantity.toString()
    }

    private fun getColorsFromJson(json: String?): List<ProductColor> {
        return if (!json.isNullOrBlank()) {
            val productColorListType = object : TypeToken<List<ProductColor>>() {}.type
            Gson().fromJson(json, productColorListType)
        } else {
            emptyList()
        }
    }
}