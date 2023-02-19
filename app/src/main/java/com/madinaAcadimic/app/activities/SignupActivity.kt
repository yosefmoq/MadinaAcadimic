package com.madinaAcadimic.app.activities

import android.R
import android.content.Intent
import android.graphics.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.madinaAcadimic.app.databinding.ActivitySignupBinding
import com.mukesh.countrypicker.CountryPicker


class SignupActivity : AppCompatActivity() {
    lateinit var activitySignupBinding:ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySignupBinding = ActivitySignupBinding.inflate(layoutInflater,null,false)
        setContentView(activitySignupBinding.root)
        activitySignupBinding.btnRegisterNow.setOnClickListener {
            startActivity(Intent(this@SignupActivity,PhoneVerificationActivity::class.java))
        }
        activitySignupBinding.llSignIn.setOnClickListener {
            startActivity(Intent(this@SignupActivity,LoginPublicActivity::class.java))
        }


        val radius = 17 * resources.displayMetrics.density
        val builder = CountryPicker.Builder().with(this@SignupActivity)
            .listener {

                val bm = BitmapFactory.decodeResource(resources, it.flag)

                val circular = getCircleCroppedBitmap(bm,radius)

                activitySignupBinding.include.ivFlag.setImageBitmap(circular)

                activitySignupBinding.include.tvCountryCode.text = it.dialCode
            }
        activitySignupBinding.include.vPhoneNumber.setOnClickListener {
            builder.build().showDialog(this@SignupActivity)
        }

    }


    fun getCircleCroppedBitmap(bitmap: Bitmap, radius: Float): Bitmap? {
        val output = Bitmap.createBitmap(
            bitmap.width,
            bitmap.height, Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(output)
        val color = -0xbdbdbe
        val paint = Paint()
        val rect = Rect(0, 0, bitmap.width, bitmap.height)
        paint.setAntiAlias(true)
        canvas.drawARGB(0, 0, 0, 0)
        paint.setColor(color)
        // canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        canvas.drawCircle(
            (bitmap.width / 2).toFloat(), (bitmap.height / 2).toFloat(),
            radius, paint
        )
        paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_IN))
        canvas.drawBitmap(bitmap, rect, rect, paint)
        //Bitmap _bmp = Bitmap.createScaledBitmap(output, 60, 60, false);
        //return _bmp;
        return output
    }

}