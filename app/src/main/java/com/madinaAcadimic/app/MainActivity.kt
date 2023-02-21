package com.madinaAcadimic.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.madinaAcadimic.app.constants.Constants
import com.madinaAcadimic.app.databinding.ActivityMainBinding
import com.madinaAcadimic.app.fragments.*

class MainActivity : AppCompatActivity() {
    companion object{
        var userType = Constants.USER
        lateinit var activityMainBinding:ActivityMainBinding

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater,null,false)
        setContentView(activityMainBinding.root)

        userType = intent.getStringExtra(Constants.USER_TYPE)!!

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val navView: BottomNavigationView = findViewById(R.id.bnv)
        navView.setupWithNavController(navController)


//        activityMainBinding.vp.isUserInputEnabled = false
//        val myBottomNavigationAdapter = MyBottomNavigationAdapter(this@MainActivity)
//        activityMainBinding.vp.adapter = myBottomNavigationAdapter
//
//        activityMainBinding.bnv.setOnItemSelectedListener {
//            when(it.itemId){
//                R.id.navHome->{
//                    activityMainBinding.vp.currentItem = 0
//                }
//                R.id.navTeachers->{
//                    activityMainBinding.vp.currentItem = 1
//                }
//                R.id.navPlans->{
//                    activityMainBinding.vp.currentItem = 2
//                }
//                R.id.navSessions->{
//                    activityMainBinding.vp.currentItem = 3
//                }
//                R.id.navAccount->{
//                    activityMainBinding.vp.currentItem = 4
//                }
//
//            }
//
//            true
//
//        }
    }

//    class MyBottomNavigationAdapter(var fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
//        override fun getItemCount(): Int =
//            5
//
//        override fun createFragment(position: Int): Fragment {
//            return  if(position == 0){
//                MainFragment()
//            }else if(position ==1) {
//                TeachersFragment()
//            }else if(position == 2){
//                PlansFragment()
//            }else if(position == 3){
//                SessionsFragment()
//            }else{
//                AccountFragment()
//            }
//        }
//
//    }
}