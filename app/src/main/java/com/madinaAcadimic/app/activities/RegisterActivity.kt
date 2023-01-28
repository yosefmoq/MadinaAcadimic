package com.madinaAcadimic.app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madinaAcadimic.app.MainActivity
import com.madinaAcadimic.app.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var activityRegisterBinding:ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRegisterBinding = ActivityRegisterBinding.inflate(layoutInflater,null,false)
        setContentView(activityRegisterBinding.root)
        activityRegisterBinding.btnRegister.setOnClickListener {
            startActivity(Intent(this@RegisterActivity,MainActivity::class.java))
        }


    }
}