package com.madinaAcadimic.app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.SimpleAdapter
import com.madinaAcadimic.app.databinding.FragmentChargeFinanciesBinding
import com.madinaAcadimic.app.databinding.FragmentPurchasesFinancesBinding


class PurchasesFinancesFragment : Fragment() {

    lateinit var binding : FragmentPurchasesFinancesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPurchasesFinancesBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSessions.adapter = SimpleAdapter(R.layout.item_purchases_financial_report,6)
        binding.ivFilter.setOnClickListener {
            val financeFilterFragment = FinancesFilterFragment()
            val bundle = Bundle()
            bundle.putInt("type", 1)
            financeFilterFragment.arguments = bundle
            financeFilterFragment.show(childFragmentManager, "FinancesFilterFragment")

        }

    }
}