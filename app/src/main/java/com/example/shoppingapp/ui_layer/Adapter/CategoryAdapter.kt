package com.example.shoppingapp.ui_layer.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.ui_layer.Models.CategoryModel
import com.example.shoppingapp.databinding.CategoryListBinding

class CategoryAdapter(var categoryList: ArrayList<CategoryModel>, var context: Context) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    inner class MyViewHolder(var binding: CategoryListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val model = categoryList[position]
            binding.apply {
                categoryImg.setImageResource(model.categoryImg)
                categoryName.text = model.categoryName
            }
            itemView.setOnClickListener {
                Toast.makeText(context, "Category : " + model.categoryName, Toast.LENGTH_SHORT)
                    .show()
            }


        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = CategoryListBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}