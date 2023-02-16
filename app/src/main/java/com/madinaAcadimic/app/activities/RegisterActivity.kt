package com.madinaAcadimic.app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.RadioGroup.OnCheckedChangeListener
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

        activityRegisterBinding.cbMale.setOnCheckedChangeListener { p0, p1 ->
            run {
                if (p1) {
                    activityRegisterBinding.cbFemale.isChecked = false
                }
            }
        }
        activityRegisterBinding.cbFemale.setOnCheckedChangeListener { p0, p1 ->
            run {
                if (p1) {
                    activityRegisterBinding.cbMale.isChecked = false
                }
            }
        }

        activityRegisterBinding.spAgeCategory.adapter = ArrayAdapter(this@RegisterActivity,android.R.layout.simple_list_item_1,
            arrayListOf<String>("test")
        )

        activityRegisterBinding.spLearningLanguage.adapter = ArrayAdapter(this@RegisterActivity,android.R.layout.simple_list_item_1,
            arrayListOf<String>("test")
        )
        activityRegisterBinding.etAgeCategory.setOnClickListener {
            activityRegisterBinding.spAgeCategory.performClick()
        }
        activityRegisterBinding.etLearningLanguage.setOnClickListener {
            activityRegisterBinding.spLearningLanguage.performClick()
        }


    }
}