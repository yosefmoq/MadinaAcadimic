package com.madinaAcadimic.app.activities

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.madinaAcadimic.app.MainActivity
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.databinding.ActivityFinancialBinding
import com.madinaAcadimic.app.fragments.*


class FinancialActivity : AppCompatActivity() {

    lateinit var binding: ActivityFinancialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityFinancialBinding.inflate(layoutInflater,null,false)
        setContentView(binding.root)


        binding.viewPager.adapter =  TabLayoutAdapter(this)


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
            onBackPressed()
        }

        binding.bnv.setOnItemSelectedListener {
            finish()
            when(it.itemId){
                R.id.navHome->{
                    MainActivity.activityMainBinding.vp.currentItem = 0
                }
                R.id.navTeachers->{
                    MainActivity.activityMainBinding.vp.currentItem = 1
                }
                R.id.navPlans->{
                    MainActivity.activityMainBinding.vp.currentItem = 2
                }
                R.id.navSessions->{
                    MainActivity.activityMainBinding.vp.currentItem = 3
                }
                R.id.navAccount->{
                    MainActivity.activityMainBinding.vp.currentItem = 4
                }

            }
            true
        }
        binding.bnv.menu[4].isChecked = true


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