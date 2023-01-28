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
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.OnItemClickListener
import com.madinaAcadimic.app.adapters.SimpleAdapter
import com.madinaAcadimic.app.databinding.DialogTeacherFilterBinding
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

            }

        })

        fragmentTeachersBinding.ivFilter.setOnClickListener {
            val dialog = Dialog(requireActivity(),R.style.MyRounded_MaterialComponents_MaterialAlertDialog)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

            val dialogTeacherFilterBinding:DialogTeacherFilterBinding = DialogTeacherFilterBinding.inflate(inflater)
            dialog.setContentView(dialogTeacherFilterBinding.root)
            val list = arrayListOf<String>()
            list.add("Younger than 6 years old")
            list.add("7-12 years")
            list.add("12-18 years")
            list.add("Older than 18 years")
            dialogTeacherFilterBinding.recyclerView.adapter = SimpleAdapter(R.layout.item_age_category,itemCountA = 4,data = list)
            val flexLayoutManager =  FlexboxLayoutManager(requireContext())
            flexLayoutManager.flexDirection = FlexDirection.COLUMN
            flexLayoutManager.justifyContent = JustifyContent.FLEX_END
            dialogTeacherFilterBinding.recyclerView.layoutManager = flexLayoutManager
            dialogTeacherFilterBinding.ivClose.setOnClickListener { dialog.dismiss() }
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

            dialog.show()
        }
        return fragmentTeachersBinding.root
        // Inflate the layout for this fragment
    }

}