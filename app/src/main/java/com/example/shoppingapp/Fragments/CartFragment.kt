package com.example.shoppingapp.Fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingapp.Adapter.CartAdapter
import com.example.shoppingapp.Adapter.WishListAdapter
import com.example.shoppingapp.CheckOutActivity
import com.example.shoppingapp.Models.ProductModel

import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.FragmentCartBinding


class CartFragment : Fragment() {
    lateinit var binding: FragmentCartBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false)
        setUpRecyclerView()

        binding.checkoutBtn.setOnClickListener {
            requireContext().startActivity(Intent(requireContext(), CheckOutActivity::class.java))
        }

        binding.backBtn.setOnClickListener {

        }
        return binding.root
    }


    private fun setUpRecyclerView() {

        val list = ArrayList<ProductModel>()
        list.add(
            ProductModel(
                productName = "One Shoulder \n" + "Linen Dress",
                productPrice = "5740",
                productImg = R.drawable.frock1,
                productCode = "GF1202",
                productDis = "7180",
                productOffer = "20% off",
                productSize = "US12",
                productColor = R.drawable.color_shape1,
                productItemCount = 2

            )
        )

        list.add(
            ProductModel(
                productName = "Cross Stitch \n" +
                        "Top",
                productPrice = "3000",
                productImg = R.drawable.frock2,
                productCode = "GF1222",
                productDis = "5280",
                productOffer = "20% off",
                productSize = "US10",
                productColor = R.drawable.color_shape3,
                productItemCount = 1
            )
        )


        list.add(
            ProductModel(
                productName = " Puff Sleeve\nDress",
                productPrice = "3000",
                productImg = R.drawable.frock2,
                productCode = "GF1222",
                productDis = "5280",
                productOffer = "20% off",
                productSize = "US10",
                productColor = R.drawable.color_shape3,
                productItemCount = 1
            )
        )


        val adapter = CartAdapter(list, requireContext())
        binding.rvCart.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCart.adapter = adapter
    }

}