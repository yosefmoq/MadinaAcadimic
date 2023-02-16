package com.madinaAcadimic.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import com.madinaAcadimic.app.MainActivity
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.NotificationDataAdapter
import com.madinaAcadimic.app.databinding.ActivityNotificationBinding
import com.madinaAcadimic.app.models.Notification
import com.madinaAcadimic.app.models.NotificationData

class NotificationActivity : AppCompatActivity() {

    lateinit var activityNotificationBinding: ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityNotificationBinding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(activityNotificationBinding.root)

        activityNotificationBinding.tvNotification.setOnClickListener {
            finish()
        }
        val n1 = Notification(
            getString(R.string.record_avalible),
            getString(R.string.test_text),
            false
        )
        val n2 = Notification(
            getString(R.string.record_avalible),
            getString(R.string.test_text),
            true
        )

        val n3 = Notification(
            getString(R.string.record_avalible),
            getString(R.string.test_text),
            true
        )

        val n4 = Notification(
            getString(R.string.record_avalible),
            getString(R.string.test_text),
            true
        )

        val nd1 = NotificationData(getString(R.string.today), listOf(n1))
        val nd2 = NotificationData(getString(R.string.yesterday), listOf(n2,n3))
        val nd3 = NotificationData(getString(R.string.test_date), listOf(n4))

        val notificationData = listOf(nd1,nd2,nd3)
        val notificationDataAdapter = NotificationDataAdapter(this@NotificationActivity,notificationData)
        activityNotificationBinding.rvNotification.adapter = notificationDataAdapter

        activityNotificationBinding.bnv.setOnItemSelectedListener {
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

        activityNotificationBinding.bnv.menu[0].isChecked = true

    }
}