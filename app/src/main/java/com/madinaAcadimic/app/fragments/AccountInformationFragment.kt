package com.madinaAcadimic.app.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.madinaAcadimic.app.MainActivity
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.constants.Constants
import com.madinaAcadimic.app.databinding.DialogConfirmBinding
import com.madinaAcadimic.app.databinding.FragmentAccountInformationBinding

class AccountInformationFragment : Fragment() {

    lateinit var binding: FragmentAccountInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountInformationBinding.inflate(layoutInflater,container,false)

        if(MainActivity.userType == Constants.USER){
            binding.etOrgnization.visibility = View.GONE
            binding.tvOrganizationTitle.visibility = View.GONE
            binding.tvPhone.visibility = View.VISIBLE

            binding.etPhoneNumber.root.visibility = View.VISIBLE

        }else{
            binding.etOrgnization.visibility = View.VISIBLE
            binding.tvOrganizationTitle.visibility = View.VISIBLE
            binding.tvEmailTitle.visibility = View.VISIBLE
            binding.etEmail.visibility = View.VISIBLE
            binding.tvPhone.visibility = View.GONE
            binding.etPhoneNumber.root.visibility = View.GONE

        }
        binding.button.setOnClickListener {
            val dialog = Dialog(requireContext(), R.style.MyRounded_MaterialComponents_MaterialAlertDialog)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            val dialogConfirmBinding = DialogConfirmBinding.inflate(layoutInflater)
            dialog.setContentView(dialogConfirmBinding.root)
            dialogConfirmBinding.tvConfirm.setOnClickListener {
                binding.button.visibility = View.GONE
                binding.tvEdit.visibility = View.VISIBLE
                binding.tvAllInfo.visibility = View.VISIBLE
                binding.llSex.visibility = View.GONE
                binding.tvMale.visibility = View.VISIBLE
                binding.etOrgnization.background = ContextCompat.getDrawable(requireContext(),R.drawable.bg_edit_text_regular)

                binding.etFirstName.isEnabled = false
                binding.etLastName.isEnabled = false
                binding.etEmail.isEnabled = false
                binding.etPhoneNumber.editTextTextPersonName.isEnabled = false
                binding.etOrgnization.isEnabled = false
                binding.etAgeCategory.isEnabled = false
                binding.etPreferedRewaya.isEnabled = false
                binding.etLearningLanguage.isEnabled = false
                binding.ivBottomAge.visibility = View.GONE
                binding.ivBottomRiwayah.visibility = View.GONE
                binding.ivLearningLanguage.visibility = View.GONE

                dialog.hide()
            }
            dialogConfirmBinding.tvCancel.setOnClickListener {
                dialog.dismiss()
            }


            dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

            dialog.show()
        }
        binding.cbMale.setOnCheckedChangeListener { p0, p1 ->
            run {
                if (p1) {
                    binding.cbFemale.isChecked = false
                }
            }
        }
        binding.cbFemale.setOnCheckedChangeListener { p0, p1 ->
            run {
                if (p1) {
                    binding.cbMale.isChecked = false
                }
            }
        }


        binding.etPhoneNumber.editTextTextPersonName.isEnabled = false

        binding.tvEdit.setOnClickListener {
            binding.button.visibility = View.VISIBLE
            binding.tvEdit.visibility = View.GONE
            binding.tvAllInfo.visibility = View.GONE
            binding.etFirstName.isEnabled = MainActivity.userType == Constants.USER
            binding.etLastName.isEnabled = MainActivity.userType == Constants.USER
            binding.etEmail.isEnabled = MainActivity.userType == Constants.USER
            binding.etPhoneNumber.editTextTextPersonName.isEnabled =
                MainActivity.userType == Constants.USER
            binding.etOrgnization.isEnabled = false
            binding.etAgeCategory.isEnabled = true
            binding.etPreferedRewaya.isEnabled = true
            binding.etLearningLanguage.isEnabled = true
            if(MainActivity.userType == Constants.USER) {
                binding.llSex.visibility = View.VISIBLE
                binding.tvMale.visibility = View.GONE
            }else{
                binding.etFirstName.background = ContextCompat.getDrawable(requireContext(),R.drawable.bg_edit_text_regular2)
                binding.etLastName.background = ContextCompat.getDrawable(requireContext(),R.drawable.bg_edit_text_regular2)
                binding.etEmail.background = ContextCompat.getDrawable(requireContext(),R.drawable.bg_edit_text_regular2)

            }
            binding.etOrgnization.background = ContextCompat.getDrawable(requireContext(),R.drawable.bg_edit_text_regular2)
            binding.ivBottomAge.visibility = View.VISIBLE
            binding.ivBottomRiwayah.visibility = View.VISIBLE
            binding.ivLearningLanguage.visibility = View.VISIBLE

        }

        binding.tvAccountInfo.setOnClickListener {
            requireActivity().onBackPressed()
        }


        binding.etPreferedRewaya.setOnClickListener {
            binding.spPreferedRewaya.performClick()
        }

        binding.etLearningLanguage.setOnClickListener {
            binding.spLearningLanguage.performClick()
        }
        binding.etAgeCategory.setOnClickListener {
            binding.spAgeCategory.performClick()
        }


        binding.spAgeCategory.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,
            arrayListOf<String>("test")
        )

        binding.spLearningLanguage.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,
            arrayListOf<String>("test")
        )
        binding.spPreferedRewaya.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,
            arrayListOf<String>("test")
        )
        
        return binding.root
    }
}