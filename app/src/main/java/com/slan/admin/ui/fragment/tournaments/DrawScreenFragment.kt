package com.slan.admin.ui.fragment.tournaments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.slan.admin.R
import com.slan.admin.data.source.local.DMyEventsDataSource
import com.slan.admin.data.source.local.DScheduleDataSource
import com.slan.admin.data.source.local.MatchesDataSource
import com.slan.admin.data.source.local.DPointDataSource
import com.slan.admin.databinding.DialogBoxSportTypesBinding
import com.slan.admin.databinding.FragmentDrawScreenBinding
import com.slan.admin.ui.adapters.tournments_a.DMyEventsRVAdapter
import com.slan.admin.ui.adapters.tournments_a.DScheduleRVAdapter
import com.slan.admin.ui.adapters.tournments_a.DrawRoundOneRVAdapter
import com.slan.admin.ui.adapters.tournments_a.MyPointsRVAdapter

class DrawScreenFragment:Fragment() {

    private lateinit var binding: FragmentDrawScreenBinding
    private val dMyEventsRVAdapter= DMyEventsRVAdapter()
    private var sportsType:String?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentDrawScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvLayoutMyEvents.adapter=dMyEventsRVAdapter
        val dataSource= DMyEventsDataSource().loadDMyEventsDataSource()
        dMyEventsRVAdapter.submitList(dataSource)

        binding.tvSport.setOnClickListener {
            showDialogSportSelection()
        }

        val round1Adapter = DrawRoundOneRVAdapter()
        val dataSourceDraw = MatchesDataSource().loadMatchesDataSource()
        binding.layoutDraw.rvRoundOnePlayers.adapter = round1Adapter

        round1Adapter.submitList(dataSourceDraw)


        val checkItem = binding.layoutDraw
        binding.layoutDraw.rgRadioGroup.setOnCheckedChangeListener { _ , id ->

            when (id) {
                R.id.rv_round1 -> {



                    checkItem.clRoundOne.visibility = View.VISIBLE
                    checkItem.clQualifier.visibility = View.GONE
                    checkItem.clFinal.visibility = View.GONE

                }

                R.id.rv_qualify -> {
                    checkItem.clRoundOne.visibility = View.GONE
                    checkItem.clQualifier.visibility = View.VISIBLE
                    checkItem.clFinal.visibility = View.GONE

                }

                R.id.rv_final -> {
                    checkItem.clRoundOne.visibility = View.GONE
                    checkItem.clQualifier.visibility = View.GONE
                    checkItem.clFinal.visibility = View.VISIBLE

                }
            }
        }



        binding.btDraw.setOnClickListener {
            binding.clDraw.visibility=View.VISIBLE
            binding.clPoints.visibility=View.GONE
            binding.clSchedules.visibility=View.GONE



            binding.btDraw.setBackgroundResource(R.drawable.orange_left)
            binding.btSchedules.setBackgroundResource(R.drawable.orange_centre_border)
            binding.btPoints.setBackgroundResource(R.drawable.orange_right_border)

            binding.btDraw.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            binding.btSchedules.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            binding.btPoints.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
        }

        binding.btSchedules.setOnClickListener {
            val dScheduleRVAdapter=DScheduleRVAdapter()
            val scheduleDataSource=DScheduleDataSource().loadDScheduleDataSource()
            binding.layoutSchedules.rvScheduleList.adapter=dScheduleRVAdapter
            dScheduleRVAdapter.submitList(scheduleDataSource)

            binding.clDraw.visibility=View.GONE
            binding.clPoints.visibility=View.GONE
            binding.clSchedules.visibility=View.VISIBLE



            binding.btDraw.setBackgroundResource(R.drawable.orange_left_border)
            binding.btSchedules.setBackgroundResource(R.drawable.orange_centre)
            binding.btPoints.setBackgroundResource(R.drawable.orange_right_border)

            binding.btDraw.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            binding.btSchedules.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            binding.btPoints.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

        }

        binding.btPoints.setOnClickListener {

            val myPointsRVAdapter=MyPointsRVAdapter()
            val pointDataSource=DPointDataSource().loadAllPointDataSource()
            binding.layoutPoints.rvPointsTable.adapter=myPointsRVAdapter
            myPointsRVAdapter.submitList(pointDataSource)


            binding.clDraw.visibility=View.GONE
            binding.clPoints.visibility=View.VISIBLE
            binding.clSchedules.visibility=View.GONE


            binding.btDraw.setBackgroundResource(R.drawable.orange_left_border)
            binding.btSchedules.setBackgroundResource(R.drawable.orange_centre_border)
            binding.btPoints.setBackgroundResource(R.drawable.orange_right)

            binding.btDraw.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            binding.btSchedules.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            binding.btPoints.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

        }

    }

    private fun showDialogSportSelection() {

        val dialogBinding = DialogBoxSportTypesBinding.inflate(LayoutInflater.from(requireContext()))
        val dialogBuilder = AlertDialog.Builder(requireContext()).setView(dialogBinding.root)
        val alertDialog = dialogBuilder.create()

        when(sportsType){
            "All"->dialogBinding.radioAll.isChecked=true
            "Tennis"->dialogBinding.radioTennis.isChecked=true
            "Cricket"->dialogBinding.radioCricket.isChecked=true
            "Football"->dialogBinding.radioFootball.isChecked=true
            "Volleyball"->dialogBinding.radioVolleyball.isChecked=true
        }

        dialogBinding.radioAll.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                sportsType="All"
            }
        }
        dialogBinding.radioTennis.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                sportsType="Tennis"
            }
        }
        dialogBinding.radioCricket.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                sportsType="Cricket"
            }
        }
        dialogBinding.radioFootball.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                sportsType="Football"
            }
        }
        dialogBinding.radioVolleyball.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                sportsType="Volleyball"
            }
        }

        dialogBinding.btnOk.setOnClickListener{
//            val radioGroup: RadioGroup =dialogBinding.rgSportsType
//            val checkedRadioButtonId= radioGroup.checkedRadioButtonId
//            val checkedButton: RadioButton =dialogBinding.rgSportsType.findViewById(checkedRadioButtonId)
//            binding.tvSport.text=checkedButton.text.toString()

            if (!sportsType.isNullOrEmpty()) {
                binding.tvSport.text=sportsType.toString()
            }

            alertDialog.dismiss()

        }
        dialogBinding.btnCancel.setOnClickListener{
            alertDialog.dismiss()
        }

        alertDialog.show()
    }


}