package com.madinaAcadimic.app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.OnItemClickListener
import com.madinaAcadimic.app.adapters.SimpleAdapter
import com.madinaAcadimic.app.databinding.FragmentAdditionalSessionsPopupBinding
import com.madinaAcadimic.app.databinding.FragmentRateTeacherPopupBinding
import com.madinaAcadimic.app.databinding.FragmentReportTeacherBinding


class ReportTeacherFragment : DialogFragment() {

    lateinit var binding : FragmentReportTeacherBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onStart() {
        super.onStart()

        requireDialog().window
            ?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT)

        if (getDialog() != null && getDialog()?.getWindow() != null) {
            getDialog()?.getWindow()?.setBackgroundDrawableResource(R.drawable.bg_popups);
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentReportTeacherBinding.inflate(layoutInflater, container, false)


        binding.ivCancel.setOnClickListener {
            dismiss()
        }


        return binding.root
    }

}