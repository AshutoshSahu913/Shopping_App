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
import com.example.shoppingapp.databinding.FavouriteListBinding
import com.example.shoppingapp.ui_layer.Models.ProductModel
import com.example.shoppingapp.ui_layer.Sheets.Activitys.ProductDetails.ProductDetailsActivity

class WishListAdapter(var favList: ArrayList<Products>, var context: Context) :
    RecyclerView.Adapter<WishListAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: FavouriteListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val model = favList[position]
            binding.apply {
                favProductName.text = model.productName
                favImg.load(model.productDisplayImage) {
                    placeholder(R.drawable.placeholder)
                }
//                productDiscountPer.text = "${model.productDiscountPercent}%off"
                favProductPrice.text = model.productPrice.toString()
                favProductCode.text=model.productCode


                itemView.setOnClickListener {
                    val intent = Intent(context, ProductDetailsActivity::class.java)
//                    intent.putExtra("name", model.productName)
//                    intent.putExtra("price", model.productPrice)
//                    intent.putExtra("img", model.productImg)

                    context.startActivity(intent)
                }
            }
        }

    }
    fun updateWishList(list: ArrayList<Products>) {
        favList.clear()
        favList.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        var binding = FavouriteListBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return favList.size
    }
}