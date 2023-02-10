package com.madinaAcadimic.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.databinding.ActivityWalletTwoBinding

class WalletTwoActivity : AppCompatActivity() {
    lateinit var activityWalletTwoBinding:ActivityWalletTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityWalletTwoBinding = ActivityWalletTwoBinding.inflate(layoutInflater)
        setContentView(activityWalletTwoBinding.root)

        activityWalletTwoBinding.tvPlans.setOnClickListener {
            finish()
        }

    }
}