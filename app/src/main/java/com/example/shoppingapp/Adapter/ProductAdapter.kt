package com.example.shoppingapp.Adapter

import android.R
import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.Models.ProductModel
import com.example.shoppingapp.databinding.ProductListBinding
import com.example.shoppingapp.productDetailsActivity


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
                productOffer.text = model.productOffer

                productDiscount.text = model.productDis
                productDiscount.paintFlags =
                    productDiscount.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            }


            itemView.setOnClickListener {
                val intent = Intent(context, productDetailsActivity::class.java)
                intent.putExtra("name", model.productName)
                intent.putExtra("price", model.productPrice)
                intent.putExtra("img", model.productImg)
//                intent.putExtra("code", model.productCode)
//                intent.putExtra("discount", model.productDis)
//                intent.putExtra("offer", model.productOffer)
                context.startActivity(intent)
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