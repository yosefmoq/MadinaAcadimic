package com.madinaAcadimic.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.databinding.ActivityStatisticsBinding

class StatisticsActivity : AppCompatActivity() {
    lateinit var activityStatisticsBinding: ActivityStatisticsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityStatisticsBinding = ActivityStatisticsBinding.inflate(layoutInflater, null, false)
        setContentView(activityStatisticsBinding.root)


        val entries = arrayListOf<BarEntry>()
        entries.add(BarEntry(8f, 0f))
        entries.add(BarEntry(2f, 1f)) 
        entries.add(BarEntry(5f, 2f)) 
        entries.add(BarEntry(20f, 3f)) 
        entries.add(BarEntry(15f, 4f)) 
        entries.add(BarEntry(19f, 5f)) 

        val bardataset = BarDataSet(entries, "Cells")

        val labels = arrayListOf<String>()
        labels.add("2016") 
        labels.add("2015") 
        labels.add("2014") 
        labels.add("2013")
        labels.add("2012")
        labels.add("2011")


//        val labelDataset = BarDataSet(labels,"labels")
        val data = BarData(bardataset)
        activityStatisticsBinding.barchart.data = data  // //
        val description = Description()
        description.text = "Set Bar Chart Description Here"// set the data and list of labels into chart
        activityStatisticsBinding.barchart.description = description// set the description

        bardataset.colors = ColorTemplate.COLORFUL_COLORS.toMutableList()
        activityStatisticsBinding.barchart.animateY(5000)

    }
}