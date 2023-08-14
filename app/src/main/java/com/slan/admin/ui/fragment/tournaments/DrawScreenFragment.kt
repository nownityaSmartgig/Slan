package com.slan.admin.ui.fragment.tournaments

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.slan.admin.R
import com.slan.admin.data.source.local.DMyEventsDataSource
import com.slan.admin.databinding.DialogBoxSportTypesBinding
import com.slan.admin.databinding.FragmentDrawScreenBinding
import com.slan.admin.ui.adapters.tournments_a.DMyEventsRVAdapter

class DrawScreenFragment:Fragment() {

    private lateinit var binding: FragmentDrawScreenBinding
    private val dMyEventsRVAdapter=DMyEventsRVAdapter()


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
        val dataSource=DMyEventsDataSource().loadDMyEventsDataSource()
        dMyEventsRVAdapter.submitList(dataSource)

        binding.tvSport.setOnClickListener {
            showDialogSportSelection()
        }

        binding.btDraw.setOnClickListener {
            binding.layoutDraw.root.visibility=View.VISIBLE
            binding.layoutPoints.root.visibility=View.GONE
            binding.layoutSchedules.root.visibility=View.GONE

            setButtonBackground(binding.btDraw, true, ContextCompat.getDrawable(requireContext(), R.drawable.button_left_curve)!!)
            setButtonBackground(binding.btSchedules, false, ContextCompat.getDrawable(requireContext(), R.drawable.button_rectangular_orange_border)!!)
            setButtonBackground(binding.btPoints, false, ContextCompat.getDrawable(requireContext(), R.drawable.button_right_curve_orange_border)!!)

        }

        binding.btSchedules.setOnClickListener {
            binding.layoutDraw.root.visibility=View.GONE
            binding.layoutPoints.root.visibility=View.GONE
            binding.layoutSchedules.root.visibility=View.VISIBLE

            setButtonBackground(binding.btDraw, false, ContextCompat.getDrawable(requireContext(), R.drawable.button_left_curve)!!)
            setButtonBackground(binding.btSchedules, true, ContextCompat.getDrawable(requireContext(), R.drawable.button_rectangular_orange_border)!!)
            setButtonBackground(binding.btPoints, false, ContextCompat.getDrawable(requireContext(), R.drawable.button_right_curve_orange_border)!!)

        }

        binding.btPoints.setOnClickListener {
            binding.layoutDraw.root.visibility=View.GONE
            binding.layoutPoints.root.visibility=View.VISIBLE
            binding.layoutSchedules.root.visibility=View.GONE

            setButtonBackground(binding.btDraw, false, ContextCompat.getDrawable(requireContext(), R.drawable.button_left_curve)!!)
            setButtonBackground(binding.btSchedules, false, ContextCompat.getDrawable(requireContext(), R.drawable.button_rectangular_orange_border)!!)
            setButtonBackground(binding.btPoints, true, ContextCompat.getDrawable(requireContext(), R.drawable.button_right_curve_orange_border)!!)
        }

    }

    private fun showDialogSportSelection() {

        val dialogBinding = DialogBoxSportTypesBinding.inflate(LayoutInflater.from(requireContext()))
        val dialogBuilder = AlertDialog.Builder(requireContext()).setView(dialogBinding.root)
        val alertDialog = dialogBuilder.create()

        dialogBinding.btnOk.setOnClickListener{
            val radioGroup: RadioGroup =dialogBinding.rgSportsType
            val checkedRadioButtonId= radioGroup.checkedRadioButtonId
            val checkedButton: RadioButton =dialogBinding.rgSportsType.findViewById(checkedRadioButtonId)
            binding.tvSport.text=checkedButton.text.toString()

            alertDialog.dismiss()

        }
        dialogBinding.btnCancel.setOnClickListener{
            alertDialog.dismiss()
        }

        alertDialog.show()
    }

    private fun setButtonBackground(button: Button, isSelected: Boolean, originalDrawable: Drawable) {
        if (isSelected) {
            button.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(button.context, R.color.orange))
            button.background = originalDrawable.constantState?.newDrawable()?.mutate()
            button.setTextColor(ContextCompat.getColor(button.context, android.R.color.white))
        } else {
            button.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(button.context, R.color.white))
            button.background = originalDrawable.constantState?.newDrawable()?.mutate()
            button.setTextColor(ContextCompat.getColor(button.context, android.R.color.black))
        }
    }

}