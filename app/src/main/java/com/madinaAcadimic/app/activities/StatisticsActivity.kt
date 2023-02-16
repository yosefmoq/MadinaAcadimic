package com.madinaAcadimic.app.activities

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.view.get
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.madinaAcadimic.app.MainActivity
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.OnItemClickListener
import com.madinaAcadimic.app.adapters.StatisticsAdapter
import com.madinaAcadimic.app.databinding.ActivityStatisticsBinding
import com.madinaAcadimic.app.databinding.DialogConfirmBinding
import com.madinaAcadimic.app.databinding.DialogStatisticsBinding
import com.madinaAcadimic.app.databinding.DialogStatisticsMonthBinding
import com.madinaAcadimic.app.models.Statistics
import im.dacer.androidcharts.BarView

class StatisticsActivity : AppCompatActivity() {
    lateinit var activityStatisticsBinding: ActivityStatisticsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityStatisticsBinding = ActivityStatisticsBinding.inflate(layoutInflater, null, false)
        setContentView(activityStatisticsBinding.root)

        val dailyData = arrayListOf<Statistics>()
        dailyData.add(Statistics(1,"Sunday","17 shawal",90, Color.parseColor("#80067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",80, Color.parseColor("#B3067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",70, Color.parseColor("#66067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",90, Color.parseColor("#99067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",40, Color.parseColor("#CC067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",60, Color.parseColor("#067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",10, Color.parseColor("#33067211")))

        activityStatisticsBinding.rvStatisticMonths.adapter = StatisticsAdapter(this@StatisticsActivity,dailyData,object:OnItemClickListener{
            override fun onItemClick(position: Int) {
                showDailyAllDialog()
            }

            override fun onViewClicked(viewID: Int) {

            }
        })
        activityStatisticsBinding.tvStatistics.setOnClickListener {
            finish()
        }


        val monthsData = arrayListOf<Statistics>()
        monthsData.add(Statistics(1,"Jumada’ 2","",30,Color.parseColor("#80067211")))
        monthsData.add(Statistics(1,"Jumada’ 1","",10,Color.parseColor("#CC067211")))
        monthsData.add(Statistics(1,"Rajab","",60,Color.parseColor("#80067211")))
        monthsData.add(Statistics(1,"Shaa’ban","",50,Color.parseColor("#66067211")))
        monthsData.add(Statistics(1,"Ramadhan","",90,Color.parseColor("#99067211")))
        monthsData.add(Statistics(1,"Shawal","",80,Color.parseColor("#99067211")))

        activityStatisticsBinding.rvStatisticYears.adapter = StatisticsAdapter(this@StatisticsActivity,monthsData,object:OnItemClickListener{
            override fun onItemClick(position: Int) {
                showDailyAllDialog()
            }
            override fun onViewClicked(viewID: Int) {

            }

        })



        activityStatisticsBinding.cvAll.setOnClickListener {
            showDailyAllDialog()
        }


        activityStatisticsBinding.cvToday.setOnClickListener {
            showDailyAllDialog()
        }


        activityStatisticsBinding.cvMonth.setOnClickListener {
            showMonthYearDialog()
        }


        activityStatisticsBinding.cvYear.setOnClickListener {
            showMonthYearDialog()
        }


        activityStatisticsBinding.bnv.setOnItemSelectedListener {
            finish()
            when(it.itemId){
                R.id.navHome->{
                    MainActivity.activityMainBinding.vp.currentItem = 0
                }
                R.id.navTeachers->{
                    MainActivity.activityMainBinding.vp.currentItem = 1
                }
                R.id.navPlans->{
                    MainActivity.activityMainBinding.vp.currentItem = 2
                }
                R.id.navSessions->{
                    MainActivity.activityMainBinding.vp.currentItem = 3
                }
                R.id.navAccount->{
                    MainActivity.activityMainBinding.vp.currentItem = 4
                }

            }
            true
        }
        activityStatisticsBinding.bnv.menu[4].isChecked = true

    }

    fun showDailyAllDialog(){
        val dialog = Dialog(this@StatisticsActivity, R.style.MyRounded_MaterialComponents_MaterialAlertDialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val dialogConfirmBinding = DialogStatisticsBinding.inflate(layoutInflater)
        dialog.setContentView(dialogConfirmBinding.root)

        dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

        dialog.show()

    }

    fun showMonthYearDialog(){
        var selectedPosition = -1;
        val dialog = Dialog(this@StatisticsActivity, R.style.MyRounded_MaterialComponents_MaterialAlertDialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val dialogConfirmBinding = DialogStatisticsMonthBinding.inflate(layoutInflater)
        dialog.setContentView(dialogConfirmBinding.root)
        val dailyData = arrayListOf<Statistics>()
        dailyData.add(Statistics(1,"Sunday","17 shawal",90, Color.parseColor("#80067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",80, Color.parseColor("#B3067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",70, Color.parseColor("#66067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",90, Color.parseColor("#99067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",40, Color.parseColor("#CC067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",60, Color.parseColor("#067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",10, Color.parseColor("#33067211")))

        dialogConfirmBinding.tvDayTitle.text = dialogConfirmBinding.tvDayTitle.text.toString().replace(System.getProperty("line.separator"), "");

        dialogConfirmBinding.rvStatisticMonths.adapter = StatisticsAdapter(this@StatisticsActivity,dailyData,object :OnItemClickListener{
            override fun onItemClick(position: Int) {
                if(selectedPosition == position){
                    dialogConfirmBinding.clDaily.visibility = View.GONE

                }else{
                    dialogConfirmBinding.clDaily.visibility = View.VISIBLE
                    selectedPosition = position

                }


            }

            override fun onViewClicked(viewID: Int) {

            }

        })

        dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

        dialog.show()


    }
}