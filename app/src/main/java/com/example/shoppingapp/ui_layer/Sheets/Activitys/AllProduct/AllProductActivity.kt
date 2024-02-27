package com.example.shoppingapp.ui_layer.Sheets.Activitys.AllProduct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.shoppingapp.Comman.Products
import com.example.shoppingapp.databinding.ActivityAllProductBinding
import com.example.shoppingapp.ui_layer.Adapter.ProductSaleAdapter
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.Circle

class AllProductActivity : AppCompatActivity() {
    val binding: ActivityAllProductBinding by lazy {
        ActivityAllProductBinding.inflate(layoutInflater)
    }
    lateinit var products: ArrayList<Products>
    lateinit var allProductViewModel: AllProductViewModel
    lateinit var allProductAdapter: ProductSaleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val _allProduct by viewModels<AllProductViewModel>(
            factoryProducer = {
                object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return AllProductViewModel(this@AllProductActivity) as T
                    }
                }
            }
        )
        allProductViewModel = _allProduct
        allProductViewModel


        binding.apply {
            backBtn.setOnClickListener {
                finish()
            }
        }


        loader()
        binding.loaderAllProduct.visibility = View.VISIBLE
        products = arrayListOf()
        allProductAdapter = ProductSaleAdapter(products, this)

        binding.rvAllProduct.layoutManager =
            GridLayoutManager(this,2, LinearLayoutManager.VERTICAL,false)

        binding.rvAllProduct.adapter = allProductAdapter

        allProductViewModel.getAllData {
            allProductAdapter.updateProductList(it)
        }
    }

    fun loader() {
        val progressBar = binding.loaderAllProduct as ProgressBar
        val circle: Sprite = Circle()
        progressBar.indeterminateDrawable = circle
    }
}