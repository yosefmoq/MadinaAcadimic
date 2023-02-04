package com.madinaAcadimic.app.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.GONE
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.databinding.ItemPlanTypeOneBinding
import com.madinaAcadimic.app.databinding.ItemPlanTypeTwoBinding

class PlanDetailsTypeTwoAdapter(val context:Context, val count:Int):
    RecyclerView.Adapter<PlanDetailsTypeTwoAdapter.ViewHolder>() {
    var isEdit = false

    class ViewHolder(val itemPlanTypeOneBinding: ItemPlanTypeTwoBinding): RecyclerView.ViewHolder(itemPlanTypeOneBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = 
        ViewHolder(ItemPlanTypeTwoBinding.inflate(LayoutInflater.from(context),parent,false))

    override fun getItemCount(): Int = count

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(isEdit){
            holder.itemPlanTypeOneBinding.linearLayout.background = ContextCompat.getDrawable(context, R.drawable.bg_gray_rad)
            holder.itemPlanTypeOneBinding.etAmount.background = ContextCompat.getDrawable(context, R.drawable.bg_gray_rad)
            holder.itemPlanTypeOneBinding.etAmount.isEnabled = true
        }else{
            holder.itemPlanTypeOneBinding.linearLayout.background = ContextCompat.getDrawable(context, R.color.transparent)
            holder.itemPlanTypeOneBinding.etAmount.background = ContextCompat.getDrawable(context, R.color.transparent)
            holder.itemPlanTypeOneBinding.etAmount.isEnabled = false
        }

        if(position == count - 1){
            holder.itemPlanTypeOneBinding.divider7.visibility = GONE
        }
    }
}