package com.example.shoppingapp.ui_layer.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.shoppingapp.Comman.Products
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.FavouriteListBinding

class CartAdapter(var cartList: ArrayList<Products>, var context: Context) :
    RecyclerView.Adapter<CartAdapter.MyViewHolder>() {
    inner class MyViewHolder(var binding: FavouriteListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val model = cartList[position]
            binding.apply {

                hideLayout.visibility = View.VISIBLE

                favImg.load(model.productDisplayImage) {
                    placeholder(R.drawable.placeholder)
                }
                favProductName.text = model.productName
                favProductPrice.text = model.productPrice.toString()
                favProductCode.text = model.productCode

//                itemQty.text = model.productItemCount.toString()

                deleteBtn.setOnClickListener {
                    cartList.removeAt(position)
                    notifyDataSetChanged()
                }
            }
        }
    }


    fun updateCartList(list: ArrayList<Products>) {
        cartList.clear()
        cartList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = FavouriteListBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }
}