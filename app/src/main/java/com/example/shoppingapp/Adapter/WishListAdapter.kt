package com.example.shoppingapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.Models.ProductModel
import com.example.shoppingapp.databinding.FavouriteListBinding
import com.example.shoppingapp.productDetailsActivity

class WishListAdapter(var favList: ArrayList<ProductModel>, var context: Context) :
    RecyclerView.Adapter<WishListAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: FavouriteListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val model = favList[position]
            binding.apply {
                favImg.setImageResource(model.productImg!!)
                favProductName.text = model.productName
                favProductPrice.text = model.productPrice
                favProductColor.setBackgroundResource(model.productColor!!)
                favProductSize.text = model.productSize
                favProductCode.text = model.productCode

                itemView.setOnClickListener {
                    val intent = Intent(context, productDetailsActivity::class.java)
                    intent.putExtra("name", model.productName)
                    intent.putExtra("price", model.productPrice)
                    intent.putExtra("img", model.productImg)

                    context.startActivity(intent)
                }
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WishListAdapter.MyViewHolder {
        var binding = FavouriteListBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: WishListAdapter.MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return favList.size
    }
}