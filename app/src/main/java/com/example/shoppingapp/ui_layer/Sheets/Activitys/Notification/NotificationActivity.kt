package com.example.shoppingapp.ui_layer.Sheets.Activitys.Notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingapp.R
import com.example.shoppingapp.ui_layer.Adapter.NotificationAdapter
import com.example.shoppingapp.ui_layer.Models.NotificationModel
import com.example.shoppingapp.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {
    val binding: ActivityNotificationBinding by lazy {
        ActivityNotificationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val list = ArrayList<NotificationModel>()
        list.add(NotificationModel("Successful purchase!", R.drawable.icon, "Just Now!"))
        list.add(NotificationModel("New Outfit for you  show now ", R.drawable.frock3, "1:00 pm"))
        list.add(NotificationModel("New Outfit for you  show now ", R.drawable.frock1, "8:00 pm"))

        val adapter = NotificationAdapter(list, this)
        binding.rvNotification.layoutManager = LinearLayoutManager(this)
        binding.rvNotification.adapter = adapter

    }
}