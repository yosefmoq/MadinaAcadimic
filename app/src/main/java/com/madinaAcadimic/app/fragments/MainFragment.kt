package com.madinaAcadimic.app.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.activities.WalletActivity
import com.madinaAcadimic.app.adapters.OnItemClickListener
import com.madinaAcadimic.app.adapters.SimpleAdapter
import com.madinaAcadimic.app.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    lateinit var fragmentMainBinding:FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentMainBinding = FragmentMainBinding.inflate(inflater,container,false)
        return fragmentMainBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentMainBinding.cpBalance.maxProgress = 100.0
        fragmentMainBinding.cpBalance.setCurrentProgress(50.0)

        fragmentMainBinding.rvTeachers.adapter = SimpleAdapter(R.layout.item_teachers, onItemClickListener = object:
            OnItemClickListener {
            override fun onItemClick(position: Int) {
                startActivity(Intent(requireContext(), TeacherDetailsFragment::class.java))
            }

            override fun onViewClicked(viewID: Int) {
            }

        })
        fragmentMainBinding.tvAll.setOnClickListener {
            findNavController().navigate(R.id.action_navHome_to_navTeachers)
        }

        fragmentMainBinding.tvAllPlans.setOnClickListener {
            findNavController().navigate(R.id.action_navHome_to_navPlans)
        }
        fragmentMainBinding.tvRecharge.setOnClickListener {
            startActivity(Intent(requireContext(),WalletActivity::class.java))
        }

        fragmentMainBinding.ivWallet.setOnClickListener {
            startActivity(Intent(requireContext(),WalletActivity::class.java))
        }

        fragmentMainBinding.ivNotification.setOnClickListener {

            findNavController().navigate(R.id.action_navHome_to_notificationFragment)

        }
        fragmentMainBinding.rvPlans.adapter = SimpleAdapter(R.layout.item_save_plan, onItemClickListener = object :OnItemClickListener{
            override fun onItemClick(position: Int) {

            }

            override fun onViewClicked(viewID: Int) {
            }

        })
    }
}