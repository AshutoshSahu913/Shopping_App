package com.example.shoppingapp.ui_layer.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.shoppingapp.Comman.Products
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.ProductListBinding
import com.example.shoppingapp.ui_layer.Sheets.Activitys.ProductDetails.ProductDetailsActivity


class ProductSaleAdapter(var saleList: ArrayList<Products>, var context: Context) :
    RecyclerView.Adapter<ProductSaleAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: ProductListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val model = saleList?.get(position)
            binding.apply {
                productName.text = model?.productName
                productPrice.text = model?.productPrice.toString()
                productImg.load(model?.productDisplayImage) {
                    placeholder(R.drawable.frock4)
                }
                productCode.text = model?.productCode
                productDiscountPer.text = "${model?.productDiscountPercent}%off"

                productMRP.text = model?.productPrice.toString()
                productMRP.paintFlags =
                    productMRP.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

                productPrice.text =
                    if (model?.productDiscountPercent == null || model?.productPrice == null) {
                        ""
                    } else {
                        "${model.productPrice!! - (model.productDiscountPercent!! / 100) * model.productPrice!!}"
                    }
            }

            itemView.setOnClickListener {
                val intent = Intent(context, ProductDetailsActivity::class.java)
                intent.putExtra("name", model?.productName)
                intent.putExtra("price", model?.productPrice)
//                intent.putExtra("img", model.productImg)
//                intent.putExtra("code", model.productCode)
//                intent.putExtra("discount", model.productDis)
//                intent.putExtra("offer", model.productOffer)
                context.startActivity(intent)
            }
        }

    }

    fun updateProductList(list: ArrayList<Products>) {
        saleList?.clear()

        saleList?.addAll(list)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        Toast.makeText(context, "run", Toast.LENGTH_SHORT).show()
        var binding = ProductListBinding.inflate(LayoutInflater.from(context), parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(position)
    }

    override fun getItemCount(): Int {
        if (saleList.isNullOrEmpty()) {
            return 0
        } else {
            return saleList!!.size
        }
    }
}