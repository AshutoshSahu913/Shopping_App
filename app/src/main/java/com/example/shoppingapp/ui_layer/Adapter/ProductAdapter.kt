package com.example.shoppingapp.ui_layer.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.ui_layer.Models.ProductModel
import com.example.shoppingapp.databinding.ProductListBinding
import com.example.shoppingapp.ui_layer.Sheets.Activitys.ProductDetails.ProductDetailsActivity


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
                val intent = Intent(context, ProductDetailsActivity::class.java)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = ProductListBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return saleList.size
    }
}