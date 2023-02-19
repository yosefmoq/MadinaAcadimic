package com.madinaAcadimic.app.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.activities.ChangePasswordActivity
import com.madinaAcadimic.app.adapters.SimpleAdapter
import com.madinaAcadimic.app.databinding.BottomSheetAddAccountBinding
import com.madinaAcadimic.app.databinding.BottomSheetChangeAccountBinding
import com.madinaAcadimic.app.databinding.FragmentAccountBinding


class AccountFragment : Fragment() {

    lateinit var fragmentAccountBinding:FragmentAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentAccountBinding = FragmentAccountBinding.inflate(inflater,container,false)
        return fragmentAccountBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentAccountBinding.tvChangeAccount.setOnClickListener {
            showChangeAccountBottomSheetDialog()
        }
        fragmentAccountBinding.tvAddAccount.setOnClickListener {
            showBottomSheetDialog()
        }
        fragmentAccountBinding.tvAccountInformation.setOnClickListener {
            findNavController().navigate(R.id.action_navAccount_to_accountInformationFragment)
        }
        fragmentAccountBinding.tvStatistics.setOnClickListener {
            findNavController().navigate(R.id.action_navAccount_to_accountInformationFragment)
        }

        fragmentAccountBinding.tvName7.setOnClickListener {
            findNavController().navigate(R.id.action_navAccount_to_financialFragment)
        }

        fragmentAccountBinding.tvChangePassword.setOnClickListener {
            startActivity(Intent(requireContext(),ChangePasswordActivity::class.java))
        }

    }

    private fun showBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        val bottomSheetAddAccountBinding = BottomSheetAddAccountBinding.inflate(layoutInflater)
        bottomSheetDialog.setContentView(bottomSheetAddAccountBinding.root)
        bottomSheetDialog.show()
    }

    private fun showChangeAccountBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        val bottomSheetAddAccountBinding = BottomSheetChangeAccountBinding.inflate(layoutInflater)
        bottomSheetDialog.setContentView(bottomSheetAddAccountBinding.root)
        bottomSheetAddAccountBinding.rvAccounts.adapter = SimpleAdapter(R.layout.item_change_account,2)
        bottomSheetDialog.show()

    }

}