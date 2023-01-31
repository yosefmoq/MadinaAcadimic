package com.madinaAcadimic.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.AddPlanAdapter
import com.madinaAcadimic.app.databinding.ActivityAddPlanBinding

class AddPlanActivity : AppCompatActivity() {
    lateinit var activityAddPlanBinding: ActivityAddPlanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityAddPlanBinding = ActivityAddPlanBinding.inflate(layoutInflater,null,false)
        setContentView(activityAddPlanBinding.root)

        val addPlanAdapter = AddPlanAdapter(3)
        activityAddPlanBinding.rvStep1.adapter = addPlanAdapter


        val addPlanAdater2 = AddPlanAdapter(5,true)
        activityAddPlanBinding.rvStep2.adapter = addPlanAdater2


        val addPlanAdapter3 = AddPlanAdapter(5,true)
        activityAddPlanBinding.rvStep3.adapter = addPlanAdapter3
    }
}