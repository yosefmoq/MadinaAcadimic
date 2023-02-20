package com.madinaAcadimic.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.NotificationDataAdapter
import com.madinaAcadimic.app.databinding.FragmentNotificationBinding
import com.madinaAcadimic.app.models.Notification
import com.madinaAcadimic.app.models.NotificationData

class NotificationFragment : Fragment() {

    private lateinit var notificationDataAdapter: NotificationDataAdapter
    lateinit var activityNotificationBinding: FragmentNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


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
        notificationDataAdapter = NotificationDataAdapter(requireContext(),notificationData)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        activityNotificationBinding = FragmentNotificationBinding.inflate(layoutInflater,container,false)

        activityNotificationBinding.tvNotification.setOnClickListener {
            requireActivity().onBackPressed()
        }



        activityNotificationBinding.rvNotification.adapter = notificationDataAdapter


        return activityNotificationBinding.root
    }
}