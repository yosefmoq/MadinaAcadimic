package com.madinaAcadimic.app.fragments

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.SimpleAdapter
import com.madinaAcadimic.app.databinding.FragmentPlanDetailsBinding


class PlanDetailsFragment : Fragment() {
    private lateinit var textViews: List<TextView>

    lateinit var binding:FragmentPlanDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPlanDetailsBinding.inflate(layoutInflater,container,false)


        binding.tvPlans.setOnClickListener {
            requireActivity().onBackPressed()
        }


        binding.rvRemaining.adapter = SimpleAdapter(R.layout.item_remaning, itemCountA = 3)
        binding.rvDetails.adapter = SimpleAdapter(R.layout.item_details, itemCountA = 3)
        binding.rvCompleted.adapter = SimpleAdapter(R.layout.item_completed, itemCountA = 3)
        binding.rvSessions.adapter = SimpleAdapter(R.layout.item_sessions, itemCountA = 3)


        binding.tvHeaderDetails.setOnClickListener {
            binding.tvHeaderDetails.setTextColor(resources.getColor(R.color.primary_color))
            binding.tvHeaderSession.setTextColor(resources.getColor(R.color.sub_text_color))
            binding.tvHeaderCompleted.setTextColor(resources.getColor(R.color.sub_text_color))
            binding.tvHeaderRemaining.setTextColor(resources.getColor(R.color.sub_text_color))
            binding.vHeaderDetails.visibility = View.VISIBLE
            binding.vHeaderSession.visibility = View.GONE
            binding.vHeaderCompleted.visibility = View.GONE
            binding.vHeaderRemaining.visibility = View.GONE

            highLightTextView(binding.tvHeaderDetails)



            binding.clDetails.visibility = View.VISIBLE
            binding.clSessions.visibility = View.GONE
            binding.clCompleted.visibility = View.GONE
            binding.clRemaining.visibility = View.GONE
        }
        binding.tvHeaderSession.setOnClickListener {
            binding.tvHeaderSession.setTextColor(resources.getColor(R.color.primary_color))
            binding.tvHeaderDetails.setTextColor(resources.getColor(R.color.sub_text_color))
            binding.tvHeaderCompleted.setTextColor(resources.getColor(R.color.sub_text_color))
            binding.tvHeaderRemaining.setTextColor(resources.getColor(R.color.sub_text_color))

            highLightTextView(binding.tvHeaderSession)


            binding.vHeaderDetails.visibility = View.GONE
            binding.vHeaderSession.visibility = View.VISIBLE
            binding.vHeaderCompleted.visibility = View.GONE
            binding.vHeaderRemaining.visibility = View.GONE
            binding.clDetails.visibility = View.GONE
            binding.clSessions.visibility = View.VISIBLE
            binding.clCompleted.visibility = View.GONE
            binding.clRemaining.visibility = View.GONE

        }
        binding.tvHeaderCompleted.setOnClickListener {
            binding.tvHeaderCompleted.setTextColor(resources.getColor(R.color.primary_color))
            binding.tvHeaderDetails.setTextColor(resources.getColor(R.color.sub_text_color))

            highLightTextView(binding.tvHeaderCompleted)



            binding.tvHeaderSession.setTextColor(resources.getColor(R.color.sub_text_color))
            binding.tvHeaderRemaining.setTextColor(resources.getColor(R.color.sub_text_color))
            binding.vHeaderDetails.visibility = View.GONE
            binding.vHeaderSession.visibility = View.GONE
            binding.vHeaderCompleted.visibility = View.VISIBLE
            binding.vHeaderRemaining.visibility = View.GONE
            binding.clDetails.visibility = View.GONE
            binding.clSessions.visibility = View.GONE
            binding.clCompleted.visibility = View.VISIBLE
            binding.clRemaining.visibility = View.GONE


        }
        binding.tvHeaderRemaining.setOnClickListener {

            highLightTextView(binding.tvHeaderRemaining)


            binding.tvHeaderRemaining.setTextColor(resources.getColor(R.color.primary_color))
            binding.tvHeaderDetails.setTextColor(resources.getColor(R.color.sub_text_color))
            binding.tvHeaderSession.setTextColor(resources.getColor(R.color.sub_text_color))
            binding.tvHeaderCompleted.setTextColor(resources.getColor(R.color.sub_text_color))
            binding.vHeaderDetails.visibility = View.GONE
            binding.vHeaderSession.visibility = View.GONE
            binding.vHeaderCompleted.visibility = View.GONE
            binding.vHeaderRemaining.visibility = View.VISIBLE
            binding.clDetails.visibility = View.GONE
            binding.clSessions.visibility = View.GONE
            binding.clCompleted.visibility = View.GONE
            binding.clRemaining.visibility = View.VISIBLE

        }

        textViews = listOf(binding.tvHeaderDetails,binding.tvHeaderCompleted,
            binding.tvHeaderRemaining,binding.tvHeaderSession)




        val root: View = binding.tabLayout.getChildAt(0)

        if (root is LinearLayout) {
            root.showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE
            root.dividerPadding = 10
            root.dividerDrawable = ResourcesCompat.getDrawable(resources,R.drawable.tab_divider,null)
        }

        return binding.root
    }

    fun highLightTextView(tagetTextView: TextView){

        for(textview in textViews){

            if (textview.id == tagetTextView.id){
                tagetTextView.setDrawableColor(R.color.primary_color)
            }else{
                textview.setDrawableColor(R.color.gray_border_color)

            }


        }

    }



}

fun TextView.setDrawableColor(color:Int){

    compoundDrawables[0].setColorFilter(
        PorterDuffColorFilter(
            ContextCompat.getColor(
                getContext(),
                color
            ), PorterDuff.Mode.SRC_IN
        )
    )

}

