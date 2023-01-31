package com.madinaAcadimic.app.activities

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.databinding.ActivityAccountInformationBinding
import com.madinaAcadimic.app.databinding.DialogConfirmBinding

class AccountInformationActivity : AppCompatActivity() {

    lateinit var activityAccountInformationBinding: ActivityAccountInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityAccountInformationBinding = ActivityAccountInformationBinding.inflate(layoutInflater,null,false)

        setContentView(activityAccountInformationBinding.root)
        activityAccountInformationBinding.button.setOnClickListener {
            val dialog = Dialog(this@AccountInformationActivity, R.style.MyRounded_MaterialComponents_MaterialAlertDialog)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            val dialogConfirmBinding = DialogConfirmBinding.inflate(layoutInflater)
            dialog.setContentView(dialogConfirmBinding.root)

            dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

            dialog.show()

        }

    }
}