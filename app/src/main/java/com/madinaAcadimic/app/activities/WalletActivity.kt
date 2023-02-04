package com.madinaAcadimic.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madinaAcadimic.app.databinding.ActivityWalletBinding

class WalletActivity : AppCompatActivity() {
    lateinit var activityWalletBinding:ActivityWalletBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityWalletBinding = ActivityWalletBinding.inflate(layoutInflater)
        setContentView(activityWalletBinding.root)

        activityWalletBinding.tvPlans.setOnClickListener {
            finish()
        }




    }
}