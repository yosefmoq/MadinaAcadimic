package com.madinaAcadimic.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.SimpleAdapter
import com.madinaAcadimic.app.databinding.ActivityPlanDetailsBinding

class PlanDetailsActivity : AppCompatActivity() {
    lateinit var activityPlanDetailsBinding:ActivityPlanDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPlanDetailsBinding = ActivityPlanDetailsBinding.inflate(layoutInflater)
        setContentView(activityPlanDetailsBinding.root)


        activityPlanDetailsBinding.tvPlans.setOnClickListener {
            finish()
        }


        activityPlanDetailsBinding.rvRemaining.adapter = SimpleAdapter(R.layout.item_remaning, itemCountA = 3)
        activityPlanDetailsBinding.rvDetails.adapter = SimpleAdapter(R.layout.item_details, itemCountA = 3)
        activityPlanDetailsBinding.rvCompleted.adapter = SimpleAdapter(R.layout.item_completed, itemCountA = 3)
        activityPlanDetailsBinding.rvSessions.adapter = SimpleAdapter(R.layout.item_sessions, itemCountA = 3)


        activityPlanDetailsBinding.tvHeaderDetails.setOnClickListener {
            activityPlanDetailsBinding.tvHeaderDetails.setTextColor(getColor(R.color.primary_color))
            activityPlanDetailsBinding.tvHeaderSession.setTextColor(getColor(R.color.sub_text_color))
            activityPlanDetailsBinding.tvHeaderCompleted.setTextColor(getColor(R.color.sub_text_color))
            activityPlanDetailsBinding.tvHeaderRemaining.setTextColor(getColor(R.color.sub_text_color))
            activityPlanDetailsBinding.vHeaderDetails.visibility = View.VISIBLE
            activityPlanDetailsBinding.vHeaderSession.visibility = View.GONE
            activityPlanDetailsBinding.vHeaderCompleted.visibility = View.GONE
            activityPlanDetailsBinding.vHeaderRemaining.visibility = View.GONE

            activityPlanDetailsBinding.clDetails.visibility = View.VISIBLE
            activityPlanDetailsBinding.clSessions.visibility = View.GONE
            activityPlanDetailsBinding.clCompleted.visibility = View.GONE
            activityPlanDetailsBinding.clRemaining.visibility = View.GONE
        }
        activityPlanDetailsBinding.tvHeaderSession.setOnClickListener {
            activityPlanDetailsBinding.tvHeaderSession.setTextColor(getColor(R.color.primary_color))
            activityPlanDetailsBinding.tvHeaderDetails.setTextColor(getColor(R.color.sub_text_color))
            activityPlanDetailsBinding.tvHeaderCompleted.setTextColor(getColor(R.color.sub_text_color))
            activityPlanDetailsBinding.tvHeaderRemaining.setTextColor(getColor(R.color.sub_text_color))
            activityPlanDetailsBinding.vHeaderDetails.visibility = View.GONE
            activityPlanDetailsBinding.vHeaderSession.visibility = View.VISIBLE
            activityPlanDetailsBinding.vHeaderCompleted.visibility = View.GONE
            activityPlanDetailsBinding.vHeaderRemaining.visibility = View.GONE
            activityPlanDetailsBinding.clDetails.visibility = View.GONE
            activityPlanDetailsBinding.clSessions.visibility = View.VISIBLE
            activityPlanDetailsBinding.clCompleted.visibility = View.GONE
            activityPlanDetailsBinding.clRemaining.visibility = View.GONE

        }
        activityPlanDetailsBinding.tvHeaderCompleted.setOnClickListener {
            activityPlanDetailsBinding.tvHeaderCompleted.setTextColor(getColor(R.color.primary_color))
            activityPlanDetailsBinding.tvHeaderDetails.setTextColor(getColor(R.color.sub_text_color))
            activityPlanDetailsBinding.tvHeaderSession.setTextColor(getColor(R.color.sub_text_color))
            activityPlanDetailsBinding.tvHeaderRemaining.setTextColor(getColor(R.color.sub_text_color))
            activityPlanDetailsBinding.vHeaderDetails.visibility = View.GONE
            activityPlanDetailsBinding.vHeaderSession.visibility = View.GONE
            activityPlanDetailsBinding.vHeaderCompleted.visibility = View.VISIBLE
            activityPlanDetailsBinding.vHeaderRemaining.visibility = View.GONE
            activityPlanDetailsBinding.clDetails.visibility = View.GONE
            activityPlanDetailsBinding.clSessions.visibility = View.GONE
            activityPlanDetailsBinding.clCompleted.visibility = View.VISIBLE
            activityPlanDetailsBinding.clRemaining.visibility = View.GONE


        }
        activityPlanDetailsBinding.tvHeaderRemaining.setOnClickListener {
            activityPlanDetailsBinding.tvHeaderRemaining.setTextColor(getColor(R.color.primary_color))
            activityPlanDetailsBinding.tvHeaderDetails.setTextColor(getColor(R.color.sub_text_color))
            activityPlanDetailsBinding.tvHeaderSession.setTextColor(getColor(R.color.sub_text_color))
            activityPlanDetailsBinding.tvHeaderCompleted.setTextColor(getColor(R.color.sub_text_color))
            activityPlanDetailsBinding.vHeaderDetails.visibility = View.GONE
            activityPlanDetailsBinding.vHeaderSession.visibility = View.GONE
            activityPlanDetailsBinding.vHeaderCompleted.visibility = View.GONE
            activityPlanDetailsBinding.vHeaderRemaining.visibility = View.VISIBLE
            activityPlanDetailsBinding.clDetails.visibility = View.GONE
            activityPlanDetailsBinding.clSessions.visibility = View.GONE
            activityPlanDetailsBinding.clCompleted.visibility = View.GONE
            activityPlanDetailsBinding.clRemaining.visibility = View.VISIBLE

        }

    }
}