package com.madinaAcadimic.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.content.ContextCompat
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.databinding.ActivityChangePasswordBinding

class ChangePasswordActivity : AppCompatActivity() {
    lateinit var activityChangePasswordBinding: ActivityChangePasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityChangePasswordBinding = ActivityChangePasswordBinding.inflate(layoutInflater,null,false)
        setContentView(activityChangePasswordBinding.root)

        activityChangePasswordBinding.etConfirmPassword.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val newPassword = activityChangePasswordBinding.etNewPassword.text.toString()
                val confirmPassword = p0.toString()
                if(confirmPassword.length < 6){
                    activityChangePasswordBinding.etConfirmPassword.background = ContextCompat.getDrawable(this@ChangePasswordActivity,R.drawable.bg_edit_text_regular)
                    activityChangePasswordBinding.tvError.visibility = View.GONE
                }else if(confirmPassword == newPassword){
                    activityChangePasswordBinding.etConfirmPassword.background = ContextCompat.getDrawable(this@ChangePasswordActivity,R.drawable.bg_edit_text_regular_green)
                    activityChangePasswordBinding.tvError.visibility = View.GONE

                }else{
                    activityChangePasswordBinding.etConfirmPassword.background = ContextCompat.getDrawable(this@ChangePasswordActivity,R.drawable.bg_edit_text_regular_red)
                    activityChangePasswordBinding.tvError.visibility = View.VISIBLE

                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        activityChangePasswordBinding.tvChangePassword.setOnClickListener {
            finish()
        }
    }
}