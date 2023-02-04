package com.madinaAcadimic.app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.SimpleAdapter
import com.madinaAcadimic.app.databinding.FragmentChargeFinanciesBinding
import com.madinaAcadimic.app.databinding.FragmentConsumptionBinding
import com.madinaAcadimic.app.databinding.FragmentPurchasesFinancesBinding

class ConsumptionFinancesFragment : Fragment() {
    lateinit var binding : FragmentConsumptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentConsumptionBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSessions.adapter = SimpleAdapter(R.layout.item_consumption_financial_report,6)

        binding.ivFilter.setOnClickListener {
            FinancesFilterFragment().show(childFragmentManager,"FinancesFilterFragment")
        }
    }
}