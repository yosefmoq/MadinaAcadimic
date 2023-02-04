package com.madinaAcadimic.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val n1 = Notification(
            "تسجيل الحصة متاح",
            "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص من مولد النص العربى، .",
            false
        )
        val n2 = Notification(
            "تسجيل الحصة متاح",
            "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص من مولد النص العربى، .",
            true
        )

        val n3 = Notification(
            "تسجيل الحصة متاح",
            "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص من مولد النص العربى، .",
            true
        )

        val n4 = Notification(
            "تسجيل الحصة متاح",
            "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص من مولد النص العربى، .",
            false
        )


        val nd1 = NotificationData("Today", listOf(n1))
        val nd2 = NotificationData("Yesterday", listOf(n2,n3))
        val nd3 = NotificationData("2/4/2022", listOf(n4))


        val notificationData = listOf<NotificationData>(nd1,nd2,nd3)
        val notificationDataAdapter = NotificationDataAdapter(this@NotificationActivity,notificationData)
        activityNotificationBinding.rvNotification.adapter = notificationDataAdapter
    }
}