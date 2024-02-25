package com.example.shoppingapp.ui_layer.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.Comman.Products
import com.example.shoppingapp.databinding.SizesListBinding

class ProductSizesAdapter(var list: ArrayList<String>, var context: Context) :
    RecyclerView.Adapter<ProductSizesAdapter.viewHolder>() {


    inner class viewHolder(val binding: SizesListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val model = list[position]
            binding.productSize.text = model
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductSizesAdapter.viewHolder {
        val binding = SizesListBinding.inflate(LayoutInflater.from(context), parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductSizesAdapter.viewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}