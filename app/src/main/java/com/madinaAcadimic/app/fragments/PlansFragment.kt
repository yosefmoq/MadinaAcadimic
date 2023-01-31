package com.madinaAcadimic.app.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.SimpleAdapter
import com.madinaAcadimic.app.databinding.FragmentPlansBinding

class PlansFragment : Fragment() {
    lateinit var fragmentPlansBinding:FragmentPlansBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentPlansBinding = FragmentPlansBinding.inflate(inflater,container,false)
        return fragmentPlansBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentPlansBinding.rvPlans.adapter = SimpleAdapter(R.layout.item_current_plans,6)


    }
}