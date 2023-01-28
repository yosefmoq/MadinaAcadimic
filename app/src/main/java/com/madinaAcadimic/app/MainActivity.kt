package com.madinaAcadimic.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.madinaAcadimic.app.databinding.ActivityMainBinding
import com.madinaAcadimic.app.fragments.MainFragment
import com.madinaAcadimic.app.fragments.TeachersFragment

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater,null,false)
        setContentView(activityMainBinding.root)

        val myBottomNavigationAdapter = MyBottomNavigationAdapter(this@MainActivity)
        activityMainBinding.vp.adapter = myBottomNavigationAdapter

        activityMainBinding.bnv.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navHome->{
                    activityMainBinding.vp.currentItem = 0
                }
                R.id.navTeachers->{
                    activityMainBinding.vp.currentItem = 1
                }
                R.id.navPlans->{
                    activityMainBinding.vp.currentItem = 2
                }
                R.id.navSessions->{
                    activityMainBinding.vp.currentItem = 4
                }
                R.id.navAccount->{
                    activityMainBinding.vp.currentItem = 5
                }

            }

            true

        }
    }

    class MyBottomNavigationAdapter(var fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int =
            5

        override fun createFragment(position: Int): Fragment {
            return  if(position == 0){
                MainFragment()
            }else{
                TeachersFragment()
            }
        }

    }
}