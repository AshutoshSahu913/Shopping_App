package com.example.shoppingapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.Models.ProductModel
import com.example.shoppingapp.databinding.ProductListBinding


class ProductAdapter(var saleList: ArrayList<ProductModel>, var context: Context) :
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {
    inner class MyViewHolder(var binding: ProductListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val model = saleList[position]
            binding.apply {
                productName.text = model.productName
                productPrice.text = model.productPrice
                productImg.setImageResource(model.productImg!!)
                productCode.text = model.productCode
                productDiscount.text = model.productDis
                productOffer.text = model.productOffer
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.MyViewHolder {
        var binding = ProductListBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductAdapter.MyViewHolder, position: Int) {

        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return saleList.size
    }
}