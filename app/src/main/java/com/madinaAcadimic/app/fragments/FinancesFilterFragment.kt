package com.madinaAcadimic.app.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.databinding.FragmentFinancesFilterBinding
import com.madinaAcadimic.app.databinding.FragmentRateTeacherPopupBinding
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class FinancesFilterFragment : DialogFragment() {

    lateinit var binding : FragmentFinancesFilterBinding


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

        binding = FragmentFinancesFilterBinding.inflate(layoutInflater, container, false)
        val type = requireArguments().getInt("type",1)
        if(type == 1){
            binding.llAdditionalFilters.visibility = View.GONE

        }else{
            binding.llAdditionalFilters.visibility = View.VISIBLE


        }
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        val dpd = DatePickerDialog(requireActivity(), DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

        }, year, month, day)


        binding.tvFromCalender.setOnClickListener {
            dpd.show()
        }

        binding.tvToCalender.setOnClickListener {
            dpd.show()

        }
        binding.ivCancel.setOnClickListener {
            dismiss()
        }


        return binding.root
    }
}