package com.madinaAcadimic.app.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.OnItemClickListener
import com.madinaAcadimic.app.adapters.SimpleAdapter
import com.madinaAcadimic.app.databinding.FragmentTeachersBinding

class TeachersFragment : Fragment() {

    lateinit var fragmentTeachersBinding: FragmentTeachersBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        fragmentTeachersBinding = FragmentTeachersBinding.inflate(inflater,container,false)
        fragmentTeachersBinding.rvTeachers.adapter = SimpleAdapter(R.layout.item_teacher_row,10, onItemClickListener = object:OnItemClickListener{
            override fun onItemClick(position: Int) {
                val dialog = Dialog(requireActivity(),R.style.MyRounded_MaterialComponents_MaterialAlertDialog)
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

                dialog.setContentView(R.layout.dialog_teacher_filter)
                dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

                dialog.show()
            }

        })
        return fragmentTeachersBinding.root
        // Inflate the layout for this fragment
    }

}