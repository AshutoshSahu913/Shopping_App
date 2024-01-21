package com.example.shoppingapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingapp.Adapter.WishListAdapter
import com.example.shoppingapp.Models.ProductModel

import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.FragmentWishListBinding


class WishListFragment : Fragment() {
    lateinit var binding: FragmentWishListBinding
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
        binding = FragmentWishListBinding.inflate(inflater, container, false)

        setUpRecyclerView()



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
                productColor = R.drawable.color_shape1
            )
        )

        list.add(
            ProductModel(
                productName = "One Shoulder \n" + "Linen Dress",
                productPrice = "5740",
                productImg = R.drawable.frock2,
                productCode = "GF1202",
                productDis = "7180",
                productOffer = "20% off",
                productSize = "US12",
                productColor = R.drawable.color_shape2
            )
        )
        list.add(
            ProductModel(
                productName = "One Shoulder \n" + "Linen Dress",
                productPrice = "5740",
                productImg = R.drawable.frock3,
                productCode = "GF1202",
                productDis = "7180",
                productOffer = "20% off",
                productSize = "US12",
                productColor = R.drawable.color_shape4

            )
        )
        list.add(
            ProductModel(
                productName = "One Shoulder \n" + "Linen Dress",
                productPrice = "5740",
                productImg = R.drawable.frock4,
                productCode = "GF1202",
                productDis = "7180",
                productOffer = "20% off",
                productSize = "US12",
                productColor = R.drawable.color_shape5
            )
        )
        list.add(
            ProductModel(
                productName = "One Shoulder \n" + "Linen Dress",
                productPrice = "5740",
                productImg = R.drawable.blouse2,
                productCode = "GF1202",
                productDis = "7180",
                productOffer = "20% off",
                productSize = "US12",
                productColor = R.drawable.color_shape3
            )
        )
        val adapter = WishListAdapter(list, requireContext())
        binding.rvFav.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFav.adapter = adapter
    }


}