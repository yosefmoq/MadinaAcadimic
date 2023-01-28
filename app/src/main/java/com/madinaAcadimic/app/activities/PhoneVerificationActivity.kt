package com.madinaAcadimic.app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.databinding.ActivityPhoneVerificationBinding

class PhoneVerificationActivity : AppCompatActivity() {

    lateinit var  activityPhoneVerificationBinding: ActivityPhoneVerificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPhoneVerificationBinding = ActivityPhoneVerificationBinding.inflate(layoutInflater,null,false)
        setContentView(activityPhoneVerificationBinding.root)
        activityPhoneVerificationBinding.btnVerification.setOnClickListener {
            startActivity(Intent(this@PhoneVerificationActivity,RegisterActivity::class.java))
        }
    }
}