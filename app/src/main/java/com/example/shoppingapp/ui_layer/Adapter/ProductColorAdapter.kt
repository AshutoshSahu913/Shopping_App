package com.example.shoppingapp.ui_layer.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.Comman.ProductColor
import com.example.shoppingapp.databinding.ColorListBinding

class ProductColorAdapter(var list: List<ProductColor>, var context: Context) :
    RecyclerView.Adapter<ProductColorAdapter.viewHolder>() {

    inner class viewHolder(var binding: ColorListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val model=list[position]
//            model.colorCode?.let { binding.productColorCode.setBackgroundColor(it) }
            model.colorCode?.let { binding.productColorCode.setBackgroundColor(it) }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductColorAdapter.viewHolder {
        val binding = ColorListBinding.inflate(LayoutInflater.from(context), parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductColorAdapter.viewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}