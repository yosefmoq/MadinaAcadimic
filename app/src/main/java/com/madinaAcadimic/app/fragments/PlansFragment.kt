package com.madinaAcadimic.app.fragments

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.activities.AddPlanActivity
import com.madinaAcadimic.app.activities.PlanDetailsActivity
import com.madinaAcadimic.app.adapters.OnItemClickListener
import com.madinaAcadimic.app.adapters.SimpleAdapter
import com.madinaAcadimic.app.databinding.FragmentPlansBinding

class PlansFragment : Fragment() {
    lateinit var fragmentPlansBinding:FragmentPlansBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentPlansBinding = FragmentPlansBinding.inflate(inflater,container,false)
        return fragmentPlansBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentPlansBinding.rvPlans.adapter = SimpleAdapter(R.layout.item_current_plans,6, onItemClickListener = object:OnItemClickListener{
            override fun onItemClick(position: Int) {
                startActivity(Intent(requireContext(),PlanDetailsActivity::class.java))
            }

            override fun onViewClicked(viewID: Int) {
            }
        })



        fragmentPlansBinding.tvCurrentPlan.setOnClickListener {
            fragmentPlansBinding.tvCurrentPlan.setTextColor(resources.getColor(R.color.primary_color))
            fragmentPlansBinding.tvCompletePlan.setTextColor(resources.getColor(R.color.sub_text_color))
            fragmentPlansBinding.vCurrentPlan.visibility = View.VISIBLE
            fragmentPlansBinding.vCompletePlan.visibility = View.GONE

        }
        fragmentPlansBinding.tvCompletePlan.setOnClickListener {
            fragmentPlansBinding.tvCompletePlan.setTextColor(resources.getColor(R.color.primary_color))
            fragmentPlansBinding.tvCurrentPlan.setTextColor(resources.getColor(R.color.sub_text_color))
            fragmentPlansBinding.vCompletePlan.visibility = View.VISIBLE
            fragmentPlansBinding.vCurrentPlan.visibility = View.GONE

        }
        fragmentPlansBinding.llAdd.setOnClickListener {
            startActivity(Intent(requireContext(),AddPlanActivity::class.java))
        }

    }
}