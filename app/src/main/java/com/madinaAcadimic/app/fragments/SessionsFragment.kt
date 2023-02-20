package com.madinaAcadimic.app.fragments

import android.app.ProgressDialog.show
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.OnItemClickListener
import com.madinaAcadimic.app.adapters.SimpleAdapter
import com.madinaAcadimic.app.databinding.FragmentSessionsBinding

class SessionsFragment : Fragment() {
    lateinit var fragmentSessionBinding:FragmentSessionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentSessionBinding = FragmentSessionsBinding.inflate(inflater,container,false)
        return fragmentSessionBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentSessionBinding.rvSessions.adapter = SimpleAdapter(R.layout.item_sessions_extended,6, onItemClickListener = object:OnItemClickListener{
            override fun onItemClick(position: Int) {
            }

            override fun onViewClicked(viewID: Int) {

                when(viewID){

                    R.id.tvTeacher->{

                        findNavController().navigate(R.id.action_navSessions_to_teacherDetailsActivity)

                    }

                    R.id.tvRate->{

                        RateTeacherPopupFragment().show(childFragmentManager,"RateTeacherPopupFragment")


                    }
                    R.id.tvReport->{

                        ReportTeacherFragment().show(childFragmentManager,"ReportTeacherFragment")


                    }
                    R.id.tvAdditionalSessions->{

                        AdditionalSessionsPopupFragment().show(childFragmentManager,"AdditionalSessions")

                    }

                }

            }
        })

        fragmentSessionBinding.tvSessionBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        fragmentSessionBinding.btnStartSession.setOnClickListener {

        }

    }
}