package com.example.shoppingapp.ui_layer.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.ProductImagesListBinding
import java.util.ArrayList

class ProductImagesAdapter(var imageList: ArrayList<String>, var context: Context) :
    RecyclerView.Adapter<ProductImagesAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: ProductImagesListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val model = imageList[position]
            binding.productImages.load(model) {
                placeholder(R.drawable.placeholder)
            }
            itemView.setOnClickListener {
                Toast.makeText(
                    context, "selected Image: $model", Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ProductImagesListBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }
}