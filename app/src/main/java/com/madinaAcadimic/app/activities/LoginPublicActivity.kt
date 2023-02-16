package com.madinaAcadimic.app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madinaAcadimic.app.MainActivity
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.constants.Constants
import com.madinaAcadimic.app.databinding.ActivityLoginPublicBinding
import com.mukesh.countrypicker.CountryPicker

class LoginPublicActivity : AppCompatActivity() {
    lateinit var activityLoginPublicBinding: ActivityLoginPublicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val builder = CountryPicker.Builder().with(this@LoginPublicActivity)
            .listener {
                activityLoginPublicBinding.include2.ivFlag.setImageResource(it.flag)
                activityLoginPublicBinding.include2.tvCountryCode.text = it.dialCode
            }
        activityLoginPublicBinding = ActivityLoginPublicBinding.inflate(layoutInflater,null,false)
        setContentView(activityLoginPublicBinding.root)

        activityLoginPublicBinding.btnLogin.setOnClickListener {
            startActivity(Intent(this@LoginPublicActivity,MainActivity::class.java).putExtra(
                Constants.USER_TYPE,Constants.USER))
        }
        activityLoginPublicBinding.btnOrganizationLogin.setOnClickListener {
            startActivity(Intent(this@LoginPublicActivity,LoginOrganizationActivity::class.java))
        }
        activityLoginPublicBinding.llRegister.setOnClickListener {
            finish()
            startActivity(Intent(this@LoginPublicActivity,SignupActivity::class.java))
        }
        activityLoginPublicBinding.tvForgetPassword.setOnClickListener {
            startActivity(Intent(this@LoginPublicActivity,ChangePasswordActivity::class.java))
        }

        activityLoginPublicBinding.include2.vPhoneNumber.setOnClickListener {
            builder.build().showDialog(this@LoginPublicActivity)
        }
    }
}