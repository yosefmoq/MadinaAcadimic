package com.madinaAcadimic.app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madinaAcadimic.app.MainActivity
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.constants.Constants
import com.madinaAcadimic.app.databinding.ActivityLoginPublicBinding

class LoginPublicActivity : AppCompatActivity() {
    lateinit var activityLoginPublicBinding: ActivityLoginPublicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
    }
}