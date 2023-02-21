package com.madinaAcadimic.app.adapters

import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.GONE
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.databinding.ItemPlanTypeOneBinding
import java.util.*

class PlanDetailsTypeOneAdapter(val context:Context,val count:Int):
    RecyclerView.Adapter<PlanDetailsTypeOneAdapter.ViewHolder>() {
    var isEdit = false

    class ViewHolder(val itemPlanTypeOneBinding: ItemPlanTypeOneBinding): RecyclerView.ViewHolder(itemPlanTypeOneBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = 
        ViewHolder(ItemPlanTypeOneBinding.inflate(LayoutInflater.from(context),parent,false))

    override fun getItemCount(): Int = count

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        val dpd = DatePickerDialog(context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

        }, year, month, day)

        if(isEdit){

            holder.itemPlanTypeOneBinding.llDate.setOnClickListener {
                dpd.show()
            }
            holder.itemPlanTypeOneBinding.llDate.background = ContextCompat.getDrawable(context, R.drawable.bg_gray_rad)
            holder.itemPlanTypeOneBinding.etFromSurah.background = ContextCompat.getDrawable(context, R.drawable.bg_gray_rad)
            holder.itemPlanTypeOneBinding.etFromAyah.background = ContextCompat.getDrawable(context, R.drawable.bg_gray_rad)
            holder.itemPlanTypeOneBinding.etToSurah.background = ContextCompat.getDrawable(context, R.drawable.bg_gray_rad)
            holder.itemPlanTypeOneBinding.etToAyah.background = ContextCompat.getDrawable(context, R.drawable.bg_gray_rad)
            holder.itemPlanTypeOneBinding.etFromSurah.isEnabled = true
            holder.itemPlanTypeOneBinding.etFromAyah.isEnabled = true
            holder.itemPlanTypeOneBinding.etToSurah.isEnabled = true
            holder.itemPlanTypeOneBinding.etToAyah.isEnabled = true
        }else{
            holder.itemPlanTypeOneBinding.llDate.background = ContextCompat.getDrawable(context, R.color.transparent)
            holder.itemPlanTypeOneBinding.etFromSurah.background = ContextCompat.getDrawable(context, R.color.transparent)
            holder.itemPlanTypeOneBinding.etFromAyah.background = ContextCompat.getDrawable(context, R.color.transparent)
            holder.itemPlanTypeOneBinding.etToSurah.background = ContextCompat.getDrawable(context, R.color.transparent)
            holder.itemPlanTypeOneBinding.etToAyah.background = ContextCompat.getDrawable(context, R.color.transparent)
            holder.itemPlanTypeOneBinding.etFromSurah.isEnabled = false
            holder.itemPlanTypeOneBinding.etFromAyah.isEnabled = false
            holder.itemPlanTypeOneBinding.etToSurah.isEnabled = false
            holder.itemPlanTypeOneBinding.etToAyah.isEnabled = false
        }

        if(position == count - 1){
            holder.itemPlanTypeOneBinding.divider7.visibility = GONE
        }
    }
}