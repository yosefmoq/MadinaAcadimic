package com.madinaAcadimic.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.AddPlanAdapter
import com.madinaAcadimic.app.adapters.PlanDetailsTypeOneAdapter
import com.madinaAcadimic.app.databinding.FragmentAddPlanBinding

class AddPlanFragment : Fragment() {
    lateinit var activityAddPlanBinding: FragmentAddPlanBinding
    var isEdit = false
    var currentStep = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        activityAddPlanBinding = FragmentAddPlanBinding.inflate(layoutInflater,null,false)

        val addPlanAdapter = AddPlanAdapter(3)
        activityAddPlanBinding.rvStep1.adapter = addPlanAdapter


        val addPlanAdater2 = AddPlanAdapter(5,true)
        activityAddPlanBinding.rvStep2.adapter = addPlanAdater2


        val addPlanAdapter3 = AddPlanAdapter(5,true)
        activityAddPlanBinding.rvStep3.adapter = addPlanAdapter3


        val planDetailsAdapter = PlanDetailsTypeOneAdapter(requireContext(),2)
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
                activityAddPlanBinding.vStep2.setBackgroundColor(resources.getColor(R.color.primary_color))
            }else if(currentStep == 3){
                currentStep = 4
                activityAddPlanBinding.btnNext.text = getString(R.string.save_plan)
                activityAddPlanBinding.clStep3.visibility = View.GONE
                activityAddPlanBinding.clStep4.visibility = View.VISIBLE
                activityAddPlanBinding.ivStep4.setImageResource(R.drawable.ic_check_active)
                activityAddPlanBinding.vStep3.setBackgroundColor(resources.getColor(R.color.primary_color))
            }
        }
        activityAddPlanBinding.tvPlans.setOnClickListener {
            if(currentStep == 1){
                requireActivity().onBackPressed()
            }else if(currentStep == 2) {
                currentStep = 1
                activityAddPlanBinding.clStep1.visibility = View.VISIBLE
                activityAddPlanBinding.clStep2.visibility = View.GONE
                activityAddPlanBinding.ivStep2.setImageResource(R.drawable.ic_check_inactive)
            }else if(currentStep == 3){
                currentStep = 2
                activityAddPlanBinding.clStep2.visibility = View.VISIBLE
                activityAddPlanBinding.clStep3.visibility = View.GONE
                activityAddPlanBinding.ivStep3.setImageResource(R.drawable.ic_check_inactive)
                activityAddPlanBinding.vStep2.setBackgroundColor(resources.getColor(R.color.sub_text_color))
                activityAddPlanBinding.btnNext.text = getString(R.string.naxt)

            }else if(currentStep == 4){
                currentStep = 3
                activityAddPlanBinding.btnNext.text = getString(R.string.naxt)

                activityAddPlanBinding.clStep3.visibility = View.VISIBLE
                activityAddPlanBinding.clStep4.visibility = View.GONE
                activityAddPlanBinding.ivStep4.setImageResource(R.drawable.ic_check_inactive)
                activityAddPlanBinding.vStep3.setBackgroundColor(resources.getColor(R.color.sub_text_color))
            }
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

        return activityAddPlanBinding.root
    }
}