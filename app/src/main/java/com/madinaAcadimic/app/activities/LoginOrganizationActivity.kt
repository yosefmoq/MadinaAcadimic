package com.madinaAcadimic.app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madinaAcadimic.app.MainActivity
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.databinding.ActivityLoginOrganizationBinding

class LoginOrganizationActivity : AppCompatActivity() {
    lateinit var activityLoginOrganizationBinding: ActivityLoginOrganizationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginOrganizationBinding = ActivityLoginOrganizationBinding.inflate(layoutInflater,null,false)
        setContentView(activityLoginOrganizationBinding.root)

        activityLoginOrganizationBinding.btnSignIn.setOnClickListener {
            startActivity(Intent(this@LoginOrganizationActivity,MainActivity::class.java))
        }
        activityLoginOrganizationBinding.llBack.setOnClickListener {
            finish()
        }
        activityLoginOrganizationBinding.tvForgetPassword.setOnClickListener {
            startActivity(Intent(this@LoginOrganizationActivity,ChangePasswordActivity::class.java))
        }
    }
}