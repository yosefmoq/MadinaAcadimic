package com.madinaAcadimic.app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.madinaAcadimic.app.databinding.ItemStatisticsBinding
import com.madinaAcadimic.app.models.Statistics


class StatisticsAdapter(val context: Context,val data:List<Statistics>,val onItemClickListener: OnItemClickListener = object:OnItemClickListener{
    override fun onItemClick(position: Int) {

    }

    override fun onViewClicked(viewID: Int) {

    }

}):
    RecyclerView.Adapter<StatisticsAdapter.ViewHolder>() {
    class ViewHolder(val itemStatisticsBinding: ItemStatisticsBinding): RecyclerView.ViewHolder(itemStatisticsBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemStatisticsBinding.inflate(LayoutInflater.from(context),parent,false))


    override fun getItemCount(): Int =data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val statistic = data[position]
        holder.itemStatisticsBinding.tvTitle.text = statistic.title
        holder.itemStatisticsBinding.tvSubTitle.text = statistic.subTitle
        val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            dpToPx(40,context), 0
        )
        params.weight = statistic.progress.toFloat()
        holder.itemStatisticsBinding.v.layoutParams = params
        holder.itemStatisticsBinding.root.requestLayout()

        holder.itemStatisticsBinding.v.setBackgroundColor(statistic.color)

        holder.itemStatisticsBinding.linearLayout6.setOnClickListener {
            onItemClickListener.onItemClick(position)
        }

    }
    fun dpToPx(dp: Int, context: Context): Int {
        val density = context.resources.displayMetrics.density
        return Math.round(dp.toFloat() * density)
    }

}


