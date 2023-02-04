package com.madinaAcadimic.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    }
}