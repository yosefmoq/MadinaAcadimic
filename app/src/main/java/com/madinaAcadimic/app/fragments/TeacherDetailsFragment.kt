package com.madinaAcadimic.app.fragments

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.madinaAcadimic.app.databinding.FragmentTeacherDetailsBinding

class TeacherDetailsFragment : Fragment() {

    lateinit var activityTeacherDetailsBinding: FragmentTeacherDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        activityTeacherDetailsBinding = FragmentTeacherDetailsBinding.inflate(layoutInflater,container,false)


        val isAvalible = arguments?.getBoolean("avalible",false)

        if(isAvalible == true){
            activityTeacherDetailsBinding.tvAvailable.visibility = View.VISIBLE
            activityTeacherDetailsBinding.llCalls.visibility = View.VISIBLE
            activityTeacherDetailsBinding.tvAvalibleLater.visibility = View.INVISIBLE
            activityTeacherDetailsBinding.tvNotifyMe.visibility = View.INVISIBLE
        }else{
            activityTeacherDetailsBinding.tvAvailable.visibility = View.INVISIBLE
            activityTeacherDetailsBinding.llCalls.visibility = View.INVISIBLE
            activityTeacherDetailsBinding.tvAvalibleLater.visibility = View.VISIBLE
            activityTeacherDetailsBinding.tvNotifyMe.visibility = View.VISIBLE

        }
        activityTeacherDetailsBinding.tvPlans.setOnClickListener {
            requireActivity().onBackPressed()
        }

        return activityTeacherDetailsBinding.root

    }


}