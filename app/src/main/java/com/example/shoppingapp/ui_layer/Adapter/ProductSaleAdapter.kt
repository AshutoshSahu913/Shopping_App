package com.example.shoppingapp.ui_layer.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.shoppingapp.Comman.ProductColor
import com.example.shoppingapp.Comman.Products
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.ProductListBinding
import com.example.shoppingapp.ui_layer.Sheets.Activitys.ProductDetails.ProductDetailsActivity
import com.google.gson.Gson


class ProductSaleAdapter(var saleList: ArrayList<Products>, var context: Context) :
    RecyclerView.Adapter<ProductSaleAdapter.MyViewHolder>() {
    inner class MyViewHolder(var binding: ProductListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val model = saleList[position]
            binding.apply {
                productName.text = model.productName
                productImg.load(model.productDisplayImage) {
                    placeholder(R.drawable.placeholder)
                }
                productCode.text = model.productCode
                productDiscountPer.text = "${model.productDiscountPercent}%off"
                productMRP.text = model.productPrice.toString()
                productMRP.paintFlags =
                    productMRP.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                productPrice.text =
                    "${model.productPrice!! - (model.productDiscountPercent!! / 100.0) * model.productPrice!!}"


            }

            itemView.setOnClickListener {
                val intent = Intent(context, ProductDetailsActivity::class.java)
                intent.putExtra("name", model.productName)
                intent.putExtra("price", model.productPrice.toString())
                intent.putExtra("img", model.productDisplayImage)
                intent.putExtra("description", model.productDes)
                intent.putStringArrayListExtra("sizes", model.productSize)
                intent.putStringArrayListExtra("images", model.productDisplayImages)

//                // Serialize the list of productColor into JSON and pass it as an extra
                val productColorJson = Gson().toJson(model.productColor)

                intent.putExtra("productColorJson", productColorJson)
                intent.putExtra("discount",model.productDiscountPercent.toString())
                intent.putExtra("code",model.productCode)

                context.startActivity(intent)
            }
        }
    }

    fun updateProductList(list: ArrayList<Products>) {
        saleList.clear()
        saleList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ProductListBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return if (saleList.isEmpty()) {
            0
        } else {
            saleList.size
        }
    }
}