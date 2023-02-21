package com.madinaAcadimic.app.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.core.view.get
import com.madinaAcadimic.app.databinding.ActivityPhoneVerificationBinding
import `in`.aabhasjindal.otptextview.ItemView
import `in`.aabhasjindal.otptextview.OTPListener


class PhoneVerificationActivity : AppCompatActivity() {

    lateinit var  activityPhoneVerificationBinding: ActivityPhoneVerificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPhoneVerificationBinding = ActivityPhoneVerificationBinding.inflate(layoutInflater,null,false)
        setContentView(activityPhoneVerificationBinding.root)
        activityPhoneVerificationBinding.btnVerification.setOnClickListener {
            startActivity(Intent(this@PhoneVerificationActivity,RegisterActivity::class.java))
        }
//        activityPhoneVerificationBinding.otpView.watc
//        activityPhoneVerificationBinding.otpView.setOTP("1234")
//
//        activityPhoneVerificationBinding.otpView.otpListener = (object : OTPListener {
//            override fun onInteractionListener() {
//                // fired when user types something in the Otpbox
//                Log.d("ttt","activityPhoneVerificationBinding.otpView.otp"+activityPhoneVerificationBinding.otpView.otp)
//                val otp = activityPhoneVerificationBinding.otpView.otp
//
////                otp?.let {
////                    for(i in 0..it.length){
////
////                        activityPhoneVerificationBinding.otpView.get(i)
////
////                        val itemView = (activityPhoneVerificationBinding.otpView.get(i) as OTPChildEditText )
////                        itemView.setViewState(ItemView.ERROR)
////
////                    }
////                }
//            }
//
//            override fun onOTPComplete(otp: String) {
//                // fired when user has entered the OTP fully.
////                Toast.makeText(this@MainActivity, "The OTP is $otp", Toast.LENGTH_SHORT).show()
//            }
//        })


//        with(activityPhoneVerificationBinding.otpView){
//
//            for(child in children){
//                ((OTPChildEditText)child)
//            }
//        }


    }
}