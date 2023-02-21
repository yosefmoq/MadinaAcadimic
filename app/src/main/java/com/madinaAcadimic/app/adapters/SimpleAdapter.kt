package com.madinaAcadimic.app.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.fragments.TeacherDetailsFragment

class SimpleAdapter(var id:Int,var itemCountA:Int = 10,var onItemClickListener:OnItemClickListener=  object :OnItemClickListener{

    override fun onItemClick(position: Int) {

    }

    override fun onViewClicked(viewID: Int) {

    }


},var data:ArrayList<String> = arrayListOf()): RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    var selectedRadio = -1

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


        try {
            val progress = holder.view.findViewById<CircularProgressIndicator>(R.id.cpBalance)
            val ivProgress = holder.view.findViewById<ImageView>(R.id.ivProgress)
            if(position%2 == 0){
                ivProgress.setImageResource(R.drawable.ic_new_progress)
            }else{
                ivProgress.setImageResource(R.drawable.ic_progress_red)

            }
            progress.maxProgress = 100.0
            progress.setCurrentProgress(15.0)
        }catch (e:java.lang.Exception){

        }




        try {

            val viewDivider = holder.view.findViewById<View>(R.id.viewDivider)
            if (position == itemCountA - 1){
                viewDivider.visibility = View.GONE
            }

        }catch (e:java.lang.Exception){

        }

        try {
            val tvTeachers = holder.view.findViewById<TextView>(R.id.tvTeacher)
            tvTeachers.setOnClickListener {

                onItemClickListener.onViewClicked(it.id)

//                holder.view.context.startActivity(Intent(holder.view.context,
//                    TeacherDetailsFragment::class.java))
            }

        }catch (e:Exception){

        }

        try {
            val iv = holder.view.findViewById<ImageView>(R.id.ivRadio)
            val cl = holder.view.findViewById<ConstraintLayout>(R.id.clParentAA)
            if(selectedRadio == position){
                iv.setImageResource(R.drawable.ic_active_rb)
            }else{
                iv.setImageResource(R.drawable.ic_inactive_radio)
            }
            iv.setOnClickListener {
                selectedRadio = position
                notifyDataSetChanged()
            }
        }catch (e:Exception){

        }

        try {

            val llSessionExtendedDetails = holder.view.findViewById<LinearLayout>(R.id.llSessionExtendedDetails)
            val ivDetailsArrow = holder.view.findViewById<ImageView>(R.id.ivDetailsArrow)
            val llArrow = holder.view.findViewById<LinearLayout>(R.id.llArrow)
            val ivRecord = holder.view.findViewById<ImageView>(R.id.ivRecord)



            llArrow.setOnClickListener {

                if(llSessionExtendedDetails.visibility == View.VISIBLE){

                    llSessionExtendedDetails.visibility = View.GONE
                    ivDetailsArrow.setImageResource(R.drawable.ic_down_arrow_session)

                }else{
                    llSessionExtendedDetails.visibility = View.VISIBLE
                    ivDetailsArrow.setImageResource(R.drawable.ic_up_arrow_session)
                }

            }


            val tvRate = holder.view.findViewById<TextView>(R.id.tvRate)
            val tvReport = holder.view.findViewById<TextView>(R.id.tvReport)
            val tvAdditionalSessions = holder.view.findViewById<TextView>(R.id.tvAdditionalSessions)


            tvRate.setOnClickListener {
                onItemClickListener.onViewClicked(it.id)
            }
            tvReport.setOnClickListener {
                onItemClickListener.onViewClicked(it.id)
            }
            tvAdditionalSessions.setOnClickListener {
                onItemClickListener.onViewClicked(it.id)
            }

            if(position == 1){

                with(tvRate){
                    setBackgroundResource(R.drawable.bg_action_done_grey_outline)
                    setTextColor(resources.getColor(R.color.gray_border_color,null))
                    setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    setText(R.string.rated)
                    isClickable = false
                }

                with(tvReport){
                    setBackgroundResource(R.drawable.bg_action_done_grey_outline)
                    setTextColor(resources.getColor(R.color.gray_border_color,null))
                    setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    setText(R.string.reported)
                    isClickable = false
                }


            }else{

                with(tvRate){
                    setBackgroundResource(R.drawable.bg_rate)
                    setTextColor(resources.getColor(R.color.yellow_color,null))
                    setCompoundDrawablesWithIntrinsicBounds(0, 0,R.drawable.ic_rate_indicator, 0);
                }

                with(tvReport){
                    setBackgroundResource(R.drawable.bg_report)
                    setTextColor(resources.getColor(R.color.our_red,null))
                    setCompoundDrawablesWithIntrinsicBounds(0, 0,R.drawable.ic_outline_report, 0);
                }


            }

            if (position == 1 || position == 3){
                ivRecord.setImageResource(R.drawable.ic_record_not_exist)
            }


        }catch (e:java.lang.Exception){

        }

        holder.view.setOnClickListener {
            onItemClickListener.onItemClick(position)
        }

    }


}