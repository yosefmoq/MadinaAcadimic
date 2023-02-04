package com.madinaAcadimic.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.AddPlanAdapter
import com.madinaAcadimic.app.adapters.PlanDetailsTypeOneAdapter
import com.madinaAcadimic.app.databinding.ActivityAddPlanBinding

class AddPlanActivity : AppCompatActivity() {
    lateinit var activityAddPlanBinding: ActivityAddPlanBinding
    var isEdit = false
    var currentStep = 1
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


        val planDetailsAdapter = PlanDetailsTypeOneAdapter(this@AddPlanActivity,2)
        activityAddPlanBinding.rvDetailsTypeOne.adapter = planDetailsAdapter




        activityAddPlanBinding.btnNext.setOnClickListener {
            if(currentStep == 1) {
                currentStep = 2
                activityAddPlanBinding.clStep1.visibility = View.GONE
                activityAddPlanBinding.clStep2.visibility = View.VISIBLE
                activityAddPlanBinding.ivStep2.setImageResource(R.drawable.ic_check_active)
            }else if(currentStep == 2){
                currentStep = 3
                activityAddPlanBinding.clStep2.visibility = View.GONE
                activityAddPlanBinding.clStep3.visibility = View.VISIBLE
                activityAddPlanBinding.ivStep3.setImageResource(R.drawable.ic_check_active)
                activityAddPlanBinding.vStep2.setBackgroundColor(getColor(R.color.primary_color))
            }else if(currentStep == 3){
                currentStep = 4
                activityAddPlanBinding.btnNext.text = getString(R.string.save_plan)
                activityAddPlanBinding.clStep3.visibility = View.GONE
                activityAddPlanBinding.clStep4.visibility = View.VISIBLE
                activityAddPlanBinding.ivStep4.setImageResource(R.drawable.ic_check_active)
                activityAddPlanBinding.vStep3.setBackgroundColor(getColor(R.color.primary_color))
            }
        }
        activityAddPlanBinding.tvPlans.setOnClickListener {
            finish()
        }
        activityAddPlanBinding.tvEdit.setOnClickListener {
            isEdit = !isEdit
            planDetailsAdapter.isEdit = isEdit
            if(isEdit){
                activityAddPlanBinding.clEditView.visibility = View.VISIBLE
                activityAddPlanBinding.tvEdit.visibility = View.GONE
            }
            planDetailsAdapter.notifyDataSetChanged()
        }

    }
}