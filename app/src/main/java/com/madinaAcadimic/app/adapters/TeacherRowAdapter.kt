package com.madinaAcadimic.app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.databinding.ItemTeacherRowBinding

class TeacherRowAdapter(val context:Context,val onItemClickListener: OnItemClickListener): RecyclerView.Adapter<TeacherRowAdapter.ViewHolder>() {
    class ViewHolder(val itemTeacherRowBinding: ItemTeacherRowBinding):RecyclerView.ViewHolder(itemTeacherRowBinding.root)
    val list = arrayListOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemTeacherRowBinding.inflate(LayoutInflater.from(context),parent,false))

    override fun getItemCount(): Int = 5

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTeacherRowBinding.ivHeart.setOnClickListener {
            if(list.contains(position)){
                list.remove(position)
            }else{
                list.add(position)
            }
            notifyDataSetChanged()
        }
        if(list.contains(position)){
            holder.itemTeacherRowBinding.ivHeart.setImageResource(R.drawable.ic_filled_heart)
        }else{
            holder.itemTeacherRowBinding.ivHeart.setImageResource(R.drawable.ic_favorite_wborder)
        }
        if(position%2 == 0){
            holder.itemTeacherRowBinding.tvCall.visibility = View.VISIBLE
            holder.itemTeacherRowBinding.tvVideoCall.visibility = View.VISIBLE
            holder.itemTeacherRowBinding.tvNotifyMe.visibility = View.GONE
            holder.itemTeacherRowBinding.tvAvalibleLater.visibility = View.GONE
            holder.itemTeacherRowBinding.tvAvailable.visibility = View.VISIBLE
        }else{
            holder.itemTeacherRowBinding.tvCall.visibility = View.GONE
            holder.itemTeacherRowBinding.tvVideoCall.visibility = View.GONE
            holder.itemTeacherRowBinding.tvNotifyMe.visibility = View.VISIBLE
            holder.itemTeacherRowBinding.tvAvalibleLater.visibility = View.VISIBLE
            holder.itemTeacherRowBinding.tvAvailable.visibility = View.GONE
        }
        holder.itemTeacherRowBinding.root.setOnClickListener {
            onItemClickListener.onItemClick(position)
        }
    }
}