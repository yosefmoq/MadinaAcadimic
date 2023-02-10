package com.madinaAcadimic.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.databinding.ActivityTeacherDetailsBinding

class TeacherDetailsActivity : AppCompatActivity() {
    lateinit var activityTeacherDetailsBinding: ActivityTeacherDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityTeacherDetailsBinding = ActivityTeacherDetailsBinding.inflate(layoutInflater)
        setContentView(activityTeacherDetailsBinding.root)
        activityTeacherDetailsBinding.tvPlans.setOnClickListener {
            finish()
        }
    }
}