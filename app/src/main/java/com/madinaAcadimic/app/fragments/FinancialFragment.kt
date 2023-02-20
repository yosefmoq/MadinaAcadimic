package com.madinaAcadimic.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.databinding.FragmentFinancialBinding
import com.madinaAcadimic.app.fragments.*


class FinancialFragment : Fragment() {

    lateinit var binding: FragmentFinancialBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFinancialBinding.inflate(layoutInflater,null,false)

        binding.viewPager.adapter =  TabLayoutAdapter(requireActivity())

        val root: View = binding.tabLayout.getChildAt(0)

        if (root is LinearLayout) {
            root.showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE
            root.dividerPadding = 10
            root.dividerDrawable = ResourcesCompat.getDrawable(resources,R.drawable.tab_divider,null)
        }

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->


            tab.text = when(position){
                0-> "All"
                1-> "Purchases"
                2-> "Charge"
                else-> "Consumption"
            }

        }.attach()
        binding.tvSessionBack.setOnClickListener{
            requireActivity().onBackPressed()
        }

        return binding.root

    }

    class TabLayoutAdapter(var fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int =
            4

        override fun createFragment(position: Int): Fragment {
            return  if(position == 0){
                AllFinancesFragment()
            }else if(position ==1) {
                PurchasesFinancesFragment()
            }else if(position == 2){
                ChargeFinanciesFragment()
            }else{
                ConsumptionFinancesFragment()
            }
        }

    }

}