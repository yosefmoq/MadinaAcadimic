package com.madinaAcadimic.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.OnItemClickListener
import com.madinaAcadimic.app.adapters.SimpleAdapter
import com.madinaAcadimic.app.databinding.ActivityMainPageOrgnaizationBinding

class MainPageOrgnaizationActivity : AppCompatActivity() {
    lateinit var activityMainPageOrgnaizationBinding: ActivityMainPageOrgnaizationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainPageOrgnaizationBinding = ActivityMainPageOrgnaizationBinding.inflate(layoutInflater,null,false)
        setContentView(activityMainPageOrgnaizationBinding.root)
    }




}