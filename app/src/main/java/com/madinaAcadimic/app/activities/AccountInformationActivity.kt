package com.madinaAcadimic.app.activities

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
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
                activityAccountInformationBinding.llSex.visibility = View.GONE
                activityAccountInformationBinding.tvMale.visibility = View.VISIBLE

                activityAccountInformationBinding.etFirstName.isEnabled = false
                activityAccountInformationBinding.etLastName.isEnabled = false
                activityAccountInformationBinding.etEmail.isEnabled = false
                activityAccountInformationBinding.etPhoneNumber.editTextTextPersonName.isEnabled = false
                activityAccountInformationBinding.etOrgnization.isEnabled = false
                activityAccountInformationBinding.etAgeCategory.isEnabled = false
                activityAccountInformationBinding.etPreferedRewaya.isEnabled = false
                activityAccountInformationBinding.etLearningLanguage.isEnabled = false

                dialog.hide()
            }
            dialogConfirmBinding.tvCancel.setOnClickListener {
                dialog.dismiss()
            }


            dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

            dialog.show()
        }
        activityAccountInformationBinding.cbMale.setOnCheckedChangeListener { p0, p1 ->
            run {
                if (p1) {
                    activityAccountInformationBinding.cbFemale.isChecked = false
                }
            }
        }
        activityAccountInformationBinding.cbFemale.setOnCheckedChangeListener { p0, p1 ->
            run {
                if (p1) {
                    activityAccountInformationBinding.cbMale.isChecked = false
                }
            }
        }



        activityAccountInformationBinding.etPhoneNumber.editTextTextPersonName.isEnabled = false

        activityAccountInformationBinding.tvEdit.setOnClickListener {
            activityAccountInformationBinding.button.visibility = View.VISIBLE
            activityAccountInformationBinding.tvEdit.visibility = View.GONE
            activityAccountInformationBinding.tvAllInfo.visibility = View.GONE
            activityAccountInformationBinding.etFirstName.isEnabled = true
            activityAccountInformationBinding.etLastName.isEnabled = true
            activityAccountInformationBinding.etEmail.isEnabled = true
            activityAccountInformationBinding.etPhoneNumber.editTextTextPersonName.isEnabled =
                MainActivity.userType == Constants.USER
            activityAccountInformationBinding.etOrgnization.isEnabled = true
            activityAccountInformationBinding.etAgeCategory.isEnabled = true
            activityAccountInformationBinding.etPreferedRewaya.isEnabled = true
            activityAccountInformationBinding.etLearningLanguage.isEnabled = true
            activityAccountInformationBinding.llSex.visibility = View.VISIBLE
            activityAccountInformationBinding.tvMale.visibility = View.GONE

        }

        activityAccountInformationBinding.tvAccountInfo.setOnClickListener {
            finish()
        }


        activityAccountInformationBinding.bnv.setOnItemSelectedListener {
            finish()
            when(it.itemId){
                R.id.navHome->{
                    MainActivity.activityMainBinding.vp.currentItem = 0
                }
                R.id.navTeachers->{
                    MainActivity.activityMainBinding.vp.currentItem = 1
                }
                R.id.navPlans->{
                    MainActivity.activityMainBinding.vp.currentItem = 2
                }
                R.id.navSessions->{
                    MainActivity.activityMainBinding.vp.currentItem = 3
                }
                R.id.navAccount->{
                    MainActivity.activityMainBinding.vp.currentItem = 4
                }

            }
            true
        }
        activityAccountInformationBinding.bnv.menu[4].isChecked = true

        activityAccountInformationBinding.etPreferedRewaya.setOnClickListener {
            activityAccountInformationBinding.spPreferedRewaya.performClick()
        }

        activityAccountInformationBinding.etLearningLanguage.setOnClickListener {
            activityAccountInformationBinding.spLearningLanguage.performClick()
        }
        activityAccountInformationBinding.etAgeCategory.setOnClickListener {
            activityAccountInformationBinding.spAgeCategory.performClick()
        }


        activityAccountInformationBinding.spAgeCategory.adapter = ArrayAdapter(this@AccountInformationActivity,android.R.layout.simple_list_item_1,
            arrayListOf<String>("test")
        )

        activityAccountInformationBinding.spLearningLanguage.adapter = ArrayAdapter(this@AccountInformationActivity,android.R.layout.simple_list_item_1,
            arrayListOf<String>("test")
        )
        activityAccountInformationBinding.spPreferedRewaya.adapter = ArrayAdapter(this@AccountInformationActivity,android.R.layout.simple_list_item_1,
            arrayListOf<String>("test")
        )
    }
}