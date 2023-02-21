package com.madinaAcadimic.app.adapters

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.databinding.ItemNotificationBinding
import com.madinaAcadimic.app.models.Notification

class NotificationAdapter(val context:Context,val data:ArrayList<Notification>):
    RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    var selected = -1
    class ViewHolder(val itemNotificationBinding: ItemNotificationBinding):RecyclerView.ViewHolder(itemNotificationBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemNotificationBinding.inflate(LayoutInflater.from(context),parent,false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notification = data[position]
        holder.itemNotificationBinding.root.setOnLongClickListener(View.OnLongClickListener {
            if(selected == position){
                selected = -1
            }else{
                selected = position
            }
            notifyDataSetChanged()
            true
        })

        holder.itemNotificationBinding.cvDelete.setOnClickListener {
            selected = -1
            data.removeAt(position)
            notifyDataSetChanged()
        }

        if(selected == position){
            holder.itemNotificationBinding.cvDelete.visibility = View.VISIBLE
        }else{
            holder.itemNotificationBinding.cvDelete.visibility = View.GONE
        }
        if(notification.isRead){
            holder.itemNotificationBinding.tvTitle.setTextColor(Color.BLACK)
            holder.itemNotificationBinding.tvDescription.setTextColor(Color.BLACK)
            holder.itemNotificationBinding.cv.setCardBackgroundColor(Color.WHITE)
//            holder.itemNotificationBinding.tvTitle.compoundDrawableTintList(ColorStateList.valueOf(context.getColor(R.color.primary_color)))
        }else{
            holder.itemNotificationBinding.tvTitle.setTextColor(Color.WHITE)
            holder.itemNotificationBinding.tvDescription.setTextColor(Color.WHITE)
            holder.itemNotificationBinding.cv.setCardBackgroundColor(context.getColor(R.color.primary_color))
//            holder.itemNotificationBinding.tvTitle.compoundDrawableTintList(ColorStateList.valueOf(context.getColor(R.color.white)))
        }

        holder.itemNotificationBinding.tvTitle.text = notification.title
        holder.itemNotificationBinding.tvDescription.text = notification.details
    }

}