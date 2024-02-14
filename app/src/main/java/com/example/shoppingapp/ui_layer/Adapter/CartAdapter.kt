package com.example.shoppingapp.ui_layer.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.ui_layer.Models.ProductModel
import com.example.shoppingapp.databinding.FavouriteListBinding

class CartAdapter(var cartList: ArrayList<ProductModel>, var context: Context) :
    RecyclerView.Adapter<CartAdapter.MyViewHolder>() {
    inner class MyViewHolder(var binding: FavouriteListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val model = cartList[position]
            binding.apply {

                hideLayout.visibility = View.VISIBLE

                favImg.setImageResource(model.productImg!!)
                favProductName.text = model.productName
                favProductPrice.text = model.productPrice
                favProductColor.setBackgroundResource(model.productColor!!)
                favProductSize.text = model.productSize
                favProductCode.text = model.productCode

                itemQty.text = model.productItemCount.toString()

                deleteBtn.setOnClickListener {
                    cartList.removeAt(position)
                    notifyDataSetChanged()
                }

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = FavouriteListBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }
}