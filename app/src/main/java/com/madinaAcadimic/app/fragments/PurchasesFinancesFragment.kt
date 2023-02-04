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

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PurchasesFinancesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PurchasesFinancesFragment : Fragment() {

    lateinit var binding : FragmentPurchasesFinancesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPurchasesFinancesBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSessions.adapter = SimpleAdapter(R.layout.item_purchases_financial_report,6)
        binding.ivFilter.setOnClickListener {
            FinancesFilterFragment().show(childFragmentManager,"FinancesFilterFragment")
        }

    }
}