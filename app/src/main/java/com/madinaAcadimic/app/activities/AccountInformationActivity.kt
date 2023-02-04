package com.madinaAcadimic.app.activities

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.madinaAcadimic.app.MainActivity
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.constants.Constants
import com.madinaAcadimic.app.databinding.ActivityAccountInformationBinding
import com.madinaAcadimic.app.databinding.DialogConfirmBinding

class AccountInformationActivity : AppCompatActivity() {

    lateinit var activityAccountInformationBinding: ActivityAccountInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityAccountInformationBinding = ActivityAccountInformationBinding.inflate(layoutInflater,null,false)

        setContentView(activityAccountInformationBinding.root)

        if(MainActivity.userType == Constants.USER){
            activityAccountInformationBinding.etOrgnization.visibility = View.GONE
            activityAccountInformationBinding.tvOrganizationTitle.visibility = View.GONE
            activityAccountInformationBinding.tvEmailTitle.visibility = View.GONE
            activityAccountInformationBinding.etEmail.visibility = View.GONE
            activityAccountInformationBinding.tvPhone.visibility = View.VISIBLE
            activityAccountInformationBinding.etPhoneNumber.root.visibility = View.VISIBLE

        }else{
            activityAccountInformationBinding.etOrgnization.visibility = View.VISIBLE
            activityAccountInformationBinding.tvOrganizationTitle.visibility = View.VISIBLE
            activityAccountInformationBinding.tvEmailTitle.visibility = View.VISIBLE
            activityAccountInformationBinding.etEmail.visibility = View.VISIBLE
            activityAccountInformationBinding.tvPhone.visibility = View.GONE
            activityAccountInformationBinding.etPhoneNumber.root.visibility = View.GONE

        }
        activityAccountInformationBinding.button.setOnClickListener {
            val dialog = Dialog(this@AccountInformationActivity, R.style.MyRounded_MaterialComponents_MaterialAlertDialog)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            val dialogConfirmBinding = DialogConfirmBinding.inflate(layoutInflater)
            dialog.setContentView(dialogConfirmBinding.root)
            dialogConfirmBinding.tvConfirm.setOnClickListener {
                activityAccountInformationBinding.button.visibility = View.GONE
                activityAccountInformationBinding.tvEdit.visibility = View.VISIBLE
                activityAccountInformationBinding.tvAllInfo.visibility = View.VISIBLE
                dialog.hide()
            }

            dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

            dialog.show()
        }

        activityAccountInformationBinding.tvEdit.setOnClickListener {
            activityAccountInformationBinding.button.visibility = View.VISIBLE
            activityAccountInformationBinding.tvEdit.visibility = View.GONE
            activityAccountInformationBinding.tvAllInfo.visibility = View.GONE
        }

        activityAccountInformationBinding.tvAccountInfo.setOnClickListener {
            finish()
        }

    }
}