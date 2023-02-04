package com.madinaAcadimic.app.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.OnItemClickListener
import com.madinaAcadimic.app.adapters.SimpleAdapter
import com.madinaAcadimic.app.databinding.FragmentAdditionalSessionsPopupBinding

class AdditionalSessionsPopupFragment : DialogFragment() {

    lateinit var binding : FragmentAdditionalSessionsPopupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setStyle(STYLE_NORMAL, R.style.FullScreenDialogTheme)

    }

    override fun onStart() {
        super.onStart()

        requireDialog().window
            ?.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT)

        if (getDialog() != null && getDialog()?.getWindow() != null) {
            getDialog()?.getWindow()?.setBackgroundDrawableResource(R.drawable.bg_popups);
        }


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdditionalSessionsPopupBinding.inflate(layoutInflater, container, false)

//        requireDialog().window?.let {
//
//            val width = resources.displayMetrics.widthPixels
//            val height = resources.displayMetrics.heightPixels
//
//            it.setLayout((width * 0.8).toInt(), height)
//
//        }


        binding.ivCancel.setOnClickListener {
            dismiss()
        }

        binding.rvSessions.adapter = SimpleAdapter(R.layout.item_additional_session,6, onItemClickListener = object:
            OnItemClickListener {
            override fun onItemClick(position: Int) {
            }

            override fun onViewClicked(viewID: Int) {
            }
        })


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}