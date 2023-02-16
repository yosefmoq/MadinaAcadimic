package com.madinaAcadimic.app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.databinding.ActivitySignupBinding
import com.mukesh.countrypicker.CountryPicker

class SignupActivity : AppCompatActivity() {
    lateinit var activitySignupBinding:ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySignupBinding = ActivitySignupBinding.inflate(layoutInflater,null,false)
        setContentView(activitySignupBinding.root)
        activitySignupBinding.btnRegisterNow.setOnClickListener {
            startActivity(Intent(this@SignupActivity,PhoneVerificationActivity::class.java))
        }
        activitySignupBinding.llSignIn.setOnClickListener {
            startActivity(Intent(this@SignupActivity,LoginPublicActivity::class.java))
        }
        val builder = CountryPicker.Builder().with(this@SignupActivity)
            .listener {
                activitySignupBinding.include.ivFlag.setImageResource(it.flag)
                activitySignupBinding.include.tvCountryCode.text = it.dialCode
            }
        activitySignupBinding.include.vPhoneNumber.setOnClickListener {
            builder.build().showDialog(this@SignupActivity)
        }

    }
}