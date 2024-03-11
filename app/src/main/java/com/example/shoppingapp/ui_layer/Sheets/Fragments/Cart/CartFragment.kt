package com.example.shoppingapp.ui_layer.Sheets.Fragments.Cart

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingapp.Comman.Products
import com.example.shoppingapp.ui_layer.Adapter.CartAdapter
import com.example.shoppingapp.ui_layer.Sheets.Activitys.CheckOut.CheckOutActivity

import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.FragmentCartBinding
import com.example.shoppingapp.ui_layer.Adapter.WishListAdapter
import com.example.shoppingapp.ui_layer.Models.ProductModel
import com.example.shoppingapp.ui_layer.Sheets.Fragments.WishList.WishListFragmentViewModel


class CartFragment : Fragment() {
    lateinit var binding: FragmentCartBinding
    lateinit var cartFragmentViewModel: CartFragmentViewModel
    private var products = ArrayList<Products>()
    private lateinit var cartAdapter: CartAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val _cartViewModel by viewModels<CartFragmentViewModel>(
            factoryProducer = {
                object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return CartFragmentViewModel(requireActivity()) as T
                    }
                }
            }
        )

        cartFragmentViewModel = _cartViewModel
        cartFragmentViewModel


        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false)
//
//       setUpRecyclerView()

        products = arrayListOf()

        cartAdapter = CartAdapter(products, requireContext())
        binding.rvCart.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.rvCart.adapter = cartAdapter

        cartFragmentViewModel.getDataFromCartList {
            cartAdapter.updateCartList(it)
        }

        binding.checkoutBtn.setOnClickListener {
            requireContext().startActivity(Intent(requireContext(), CheckOutActivity::class.java))
        }

        binding.backBtn.setOnClickListener {
            activity?.finish()
        }
        return binding.root
    }
}