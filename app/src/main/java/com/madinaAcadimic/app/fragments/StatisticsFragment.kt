package com.madinaAcadimic.app.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.Fragment
import com.madinaAcadimic.app.R
import com.madinaAcadimic.app.adapters.OnItemClickListener
import com.madinaAcadimic.app.adapters.StatisticsAdapter
import com.madinaAcadimic.app.databinding.DialogStatisticsBinding
import com.madinaAcadimic.app.databinding.DialogStatisticsMonthBinding
import com.madinaAcadimic.app.databinding.FragmentStatisticsBinding
import com.madinaAcadimic.app.models.Statistics

class StatisticsFragment : Fragment() {
    lateinit var binding: FragmentStatisticsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentStatisticsBinding.inflate(layoutInflater, container, false)

        val dailyData = arrayListOf<Statistics>()
        dailyData.add(Statistics(1,"Sunday","17 shawal",90, Color.parseColor("#80067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",80, Color.parseColor("#B3067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",70, Color.parseColor("#66067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",90, Color.parseColor("#99067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",40, Color.parseColor("#CC067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",60, Color.parseColor("#067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",10, Color.parseColor("#33067211")))

        binding.rvStatisticMonths.adapter = StatisticsAdapter(requireContext(),dailyData,object:OnItemClickListener{
            override fun onItemClick(position: Int) {
                showDailyAllDialog()
            }

            override fun onViewClicked(viewID: Int) {

            }
        })
        binding.tvStatistics.setOnClickListener {
            requireActivity().onBackPressed()
        }


        val monthsData = arrayListOf<Statistics>()
        monthsData.add(Statistics(1,"Jumada’ 2","",30,Color.parseColor("#80067211")))
        monthsData.add(Statistics(1,"Jumada’ 1","",10,Color.parseColor("#CC067211")))
        monthsData.add(Statistics(1,"Rajab","",60,Color.parseColor("#80067211")))
        monthsData.add(Statistics(1,"Shaa’ban","",50,Color.parseColor("#66067211")))
        monthsData.add(Statistics(1,"Ramadhan","",90,Color.parseColor("#99067211")))
        monthsData.add(Statistics(1,"Shawal","",80,Color.parseColor("#99067211")))

        binding.rvStatisticYears.adapter = StatisticsAdapter(requireContext(),monthsData,object:OnItemClickListener{
            override fun onItemClick(position: Int) {
                showDailyAllDialog()
            }
            override fun onViewClicked(viewID: Int) {

            }

        })



        binding.cvAll.setOnClickListener {
            showDailyAllDialog()
        }


        binding.cvToday.setOnClickListener {
            showDailyAllDialog()
        }


        binding.cvMonth.setOnClickListener {
            showMonthYearDialog()
        }


        binding.cvYear.setOnClickListener {
            showMonthYearDialog()
        }
    
        return binding.root
    }
    fun showDailyAllDialog(){
        val dialog = Dialog(requireContext(), R.style.MyRounded_MaterialComponents_MaterialAlertDialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val dialogConfirmBinding = DialogStatisticsBinding.inflate(layoutInflater)
        dialog.setContentView(dialogConfirmBinding.root)

        dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

        dialog.show()

    }

    fun showMonthYearDialog(){
        var selectedPosition = -1;
        val dialog = Dialog(requireContext(), R.style.MyRounded_MaterialComponents_MaterialAlertDialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val dialogConfirmBinding = DialogStatisticsMonthBinding.inflate(layoutInflater)
        dialog.setContentView(dialogConfirmBinding.root)
        val dailyData = arrayListOf<Statistics>()
        dailyData.add(Statistics(1,"Sunday","17 shawal",90, Color.parseColor("#80067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",80, Color.parseColor("#B3067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",70, Color.parseColor("#66067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",90, Color.parseColor("#99067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",40, Color.parseColor("#CC067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",60, Color.parseColor("#067211")))
        dailyData.add(Statistics(1,"Sunday","17 shawal",10, Color.parseColor("#33067211")))

        dialogConfirmBinding.tvDayTitle.text = dialogConfirmBinding.tvDayTitle.text.toString().replace(System.getProperty("line.separator"), "");

        dialogConfirmBinding.rvStatisticMonths.adapter = StatisticsAdapter(requireContext(),dailyData,object :OnItemClickListener{
            override fun onItemClick(position: Int) {
                if(selectedPosition == position){
                    dialogConfirmBinding.clDaily.visibility = View.GONE

                }else{
                    dialogConfirmBinding.clDaily.visibility = View.VISIBLE
                    selectedPosition = position

                }


            }

            override fun onViewClicked(viewID: Int) {

            }

        })

        dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

        dialog.show()


    }
}