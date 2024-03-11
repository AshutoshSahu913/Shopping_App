package com.example.shoppingapp.ui_layer.Sheets.Fragments.WishList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingapp.Comman.Products
import com.example.shoppingapp.ui_layer.Adapter.WishListAdapter

import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.FragmentWishListBinding
import com.example.shoppingapp.ui_layer.Adapter.ProductSaleAdapter
import com.example.shoppingapp.ui_layer.Models.ProductModel
import com.example.shoppingapp.ui_layer.Sheets.Fragments.Home.HomeFragmentViewModel
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.Circle


class WishListFragment : Fragment() {
    lateinit var binding: FragmentWishListBinding
    lateinit var wishListViewModel: WishListFragmentViewModel
    private var products = ArrayList<Products>()
    private lateinit var wishListAdapter: WishListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val _wishlistViewModel by viewModels<WishListFragmentViewModel>(
            factoryProducer = {
                object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return WishListFragmentViewModel(requireActivity()) as T
                    }
                }
            }
        )

        wishListViewModel = _wishlistViewModel
        wishListViewModel


        // Inflate the layout for this fragment
        binding = FragmentWishListBinding.inflate(inflater, container, false)

        loader()
        binding.loaderWishlist.visibility = View.VISIBLE
        products = arrayListOf()

        wishListAdapter = WishListAdapter(products, requireContext())
        binding.rvFav.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.rvFav.adapter = wishListAdapter

        wishListViewModel.getDataFromWishlist {
            wishListAdapter.updateWishList(it)

        }
        return binding.root
    }

    fun loader() {
        val progressBar = binding.loaderWishlist as ProgressBar
        val circle: Sprite = Circle()
        progressBar.indeterminateDrawable = circle
    }
}
