package com.example.shoppingapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.Models.ProductModel
import com.example.shoppingapp.databinding.SaleListBinding

class SaleAdapter(var saleList: ArrayList<ProductModel>, var context: Context) :
    RecyclerView.Adapter<SaleAdapter.MyViewHolder>() {
    inner class MyViewHolder(var binding: SaleListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {


            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaleAdapter.MyViewHolder {
        var binding = SaleListBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SaleAdapter.MyViewHolder, position: Int) {

        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return saleList.size
    }
}