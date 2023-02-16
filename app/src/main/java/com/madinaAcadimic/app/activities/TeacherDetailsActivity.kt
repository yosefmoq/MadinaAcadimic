package com.madinaAcadimic.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.get
import com.madinaAcadimic.app.MainActivity
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.databinding.ActivityTeacherDetailsBinding

class TeacherDetailsActivity : AppCompatActivity() {
    lateinit var activityTeacherDetailsBinding: ActivityTeacherDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityTeacherDetailsBinding = ActivityTeacherDetailsBinding.inflate(layoutInflater)
        setContentView(activityTeacherDetailsBinding.root)
        val isAvalible = intent.getBooleanExtra("avalible",false)
        if(isAvalible){
            activityTeacherDetailsBinding.tvAvailable.visibility = View.VISIBLE
            activityTeacherDetailsBinding.llCalls.visibility = View.VISIBLE
            activityTeacherDetailsBinding.tvAvalibleLater.visibility = View.INVISIBLE
            activityTeacherDetailsBinding.tvNotifyMe.visibility = View.INVISIBLE
        }else{
            activityTeacherDetailsBinding.tvAvailable.visibility = View.INVISIBLE
            activityTeacherDetailsBinding.llCalls.visibility = View.INVISIBLE
            activityTeacherDetailsBinding.tvAvalibleLater.visibility = View.VISIBLE
            activityTeacherDetailsBinding.tvNotifyMe.visibility = View.VISIBLE

        }
        activityTeacherDetailsBinding.tvPlans.setOnClickListener {
            finish()
        }
        activityTeacherDetailsBinding.bnv.setOnItemSelectedListener {
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
        activityTeacherDetailsBinding.bnv.menu[1].isChecked = true


    }
}