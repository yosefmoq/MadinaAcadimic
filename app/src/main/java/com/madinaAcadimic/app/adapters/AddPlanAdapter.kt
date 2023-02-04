package com.madinaAcadimic.app.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madinaAcadimic.app.databinding.ItemAddPlanBinding

class AddPlanAdapter(val count:Int,val showIcon:Boolean = false): RecyclerView.Adapter<AddPlanAdapter.ViewHolder>() {
    var selectedIndex = -1
    var isEdit = false
    class ViewHolder(val itemAddPlanBinding:ItemAddPlanBinding) : RecyclerView.ViewHolder(itemAddPlanBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemAddPlanBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int = count

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemAddPlanBinding.root.setOnClickListener {
            selectedIndex = position
            notifyDataSetChanged()
        }


        if(showIcon){
            holder.itemAddPlanBinding.ivIcon.visibility = View.VISIBLE
        }else{
            holder.itemAddPlanBinding.ivIcon.visibility = View.GONE

        }

        if(selectedIndex == position){
            holder.itemAddPlanBinding.ivActive.visibility = View.VISIBLE
            holder.itemAddPlanBinding.cv.setCardBackgroundColor(Color.parseColor("#DFF9E6"))
        }else{
            holder.itemAddPlanBinding.ivActive.visibility = View.GONE
            holder.itemAddPlanBinding.cv.setCardBackgroundColor(Color.parseColor("#FFFFFF"))

        }
    }
}