package com.madinaAcadimic.app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madinaAcadimic.app.databinding.ItemNotificationDataBinding
import com.madinaAcadimic.app.models.NotificationData

class NotificationDataAdapter(val context: Context,val data:List<NotificationData>):
    RecyclerView.Adapter<NotificationDataAdapter.ViewHolder>() {
    class ViewHolder(val itemNotificationDataBinding:ItemNotificationDataBinding):RecyclerView.ViewHolder(itemNotificationDataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemNotificationDataBinding.inflate(LayoutInflater.from(context),parent,false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(position == 0){
            holder.itemNotificationDataBinding.tvDeleteAll.visibility = View.VISIBLE
        }else{
            holder.itemNotificationDataBinding.tvDeleteAll.visibility = View.GONE
        }
        holder.itemNotificationDataBinding.textView57.text = data[position].title

        val notificationAdapter = NotificationAdapter(context,data[position].data)
        holder.itemNotificationDataBinding.rv.adapter = notificationAdapter
    }


}