package com.madinaAcadimic.app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.NumberPicker
import android.widget.NumberPicker.OnValueChangeListener
import com.madinaAcadimic.app.databinding.ActivityWalletBinding
import kotlin.math.floor
import kotlin.math.roundToInt

class WalletActivity : AppCompatActivity() {
    lateinit var activityWalletBinding:ActivityWalletBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityWalletBinding = ActivityWalletBinding.inflate(layoutInflater)
        setContentView(activityWalletBinding.root)

        activityWalletBinding.numberPickerMin.minValue = 0
        activityWalletBinding.numberPickerMin.maxValue = 1000


        activityWalletBinding.numberPickerPrice.minValue = 0
        activityWalletBinding.numberPickerPrice.maxValue = 1000


        activityWalletBinding.numberPickerPrice.isEnabled = false


        activityWalletBinding.numberPickerMin.setOnValueChangedListener { p0, p1, p2 ->
            run {
                Log.v("ttt", "aaaa$p2")
                activityWalletBinding.numberPickerPrice.value = (p2 * 0.19).roundToInt()
            }
        }
        activityWalletBinding.tvPlans.setOnClickListener {
            finish()
        }

        activityWalletBinding.tvOrderDetails.setOnClickListener {
            startActivity(Intent(this@WalletActivity,WalletTwoActivity::class.java))
        }




    }
}