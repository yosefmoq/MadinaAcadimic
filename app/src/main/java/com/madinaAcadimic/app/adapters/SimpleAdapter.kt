package com.madinaAcadimic.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.madinaAcadimic.app.R

class SimpleAdapter(var id:Int,var itemCountA:Int = 10,var onItemClickListener:OnItemClickListener=  object :OnItemClickListener{
    override fun onItemClick(position: Int) {

    }
},var data:ArrayList<String> = arrayListOf()): RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    class ViewHolder(var view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(id,parent,false))

    override fun getItemCount(): Int =
        itemCountA

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(data.isNotEmpty()){
            val textView = holder.view.findViewById<TextView>(R.id.tvAgeCategory)
            textView.text = data[position]
            if(position ==0 ){
                textView.background = ContextCompat.getDrawable(holder.view.context,R.drawable.bg_text_green)
            }else{
                textView.background = ContextCompat.getDrawable(holder.view.context,R.drawable.bg_text_gray)
            }
        }
        holder.view.setOnClickListener {
            onItemClickListener.onItemClick(position)
        }

    }


}