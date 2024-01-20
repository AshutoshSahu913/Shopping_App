package com.example.shoppingapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.Models.NotificationModel
import com.example.shoppingapp.databinding.FragmentHomeBinding
import com.example.shoppingapp.databinding.NotificationListBinding

class NotificationAdapter(
    var notificationList: ArrayList<NotificationModel>,
    var context: Context
) :
    RecyclerView.Adapter<NotificationAdapter.MyViewHolder>() {
    inner class MyViewHolder(var binding: NotificationListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val model = notificationList[position]
            binding.apply {
                notificationImg.setImageResource(model.notificationImg)
                notificationTxt.text = model.notificationTxt
                notificationTime.text = model.notificationTime
            }

        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotificationAdapter.MyViewHolder {
        val binding = NotificationListBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationAdapter.MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }
}