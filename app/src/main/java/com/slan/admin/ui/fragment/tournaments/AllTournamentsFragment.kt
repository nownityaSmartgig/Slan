package com.slan.admin.ui.fragment.tournaments

import android.os.Binder
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import com.slan.admin.R
import com.slan.admin.data.source.local.AllTournamentDataSource
import com.slan.admin.databinding.DialogBoxSelectOptionBinding
import com.slan.admin.databinding.DialogBoxSportTypesBinding
import com.slan.admin.databinding.FragmentAllTournamentsBinding
import com.slan.admin.ui.adapters.tournments_a.AllTournamentRVAdapter

class AllTournamentsFragment : Fragment() {


    companion object {
        fun newInstance() = AllTournamentsFragment()
    }
    private lateinit var viewModel: AllTournamentsViewModel

    private lateinit var binding: FragmentAllTournamentsBinding
    private val allTournamentAdapter=AllTournamentRVAdapter()

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAllTournamentsBinding.inflate(inflater,container,false)
        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(AllTournamentsViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.rvTournamentList.adapter = allTournamentAdapter
        val dataSource = AllTournamentDataSource().loadAllTournamentDataSource()
        allTournamentAdapter.submitList(dataSource)

        binding.tvCurrent.setOnClickListener{
            showDialogSelectOption()
        }

        binding.tvSport.setOnClickListener{
            showDialogSportSelection()
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

    private fun showDialogSelectOption(){
        val dialogSelectBinding= DialogBoxSelectOptionBinding.inflate(LayoutInflater.from(requireContext()))
        val dialogBuilder=AlertDialog.Builder(requireContext()).setView(dialogSelectBinding.root)
        val alertDialog=dialogBuilder.create()



        dialogSelectBinding.btnOk.setOnClickListener{
            val radioGroup=dialogSelectBinding.rgSelectOption
            val checkedRadioButtonId=radioGroup.checkedRadioButtonId
            val checkedButton:RadioButton=dialogSelectBinding.rgSelectOption.findViewById(checkedRadioButtonId)
            binding.tvCurrent.text=checkedButton.text.toString()

            alertDialog.dismiss()
        }
        dialogSelectBinding.btnCancel.setOnClickListener{
            alertDialog.dismiss()
        }

        alertDialog.show()

    }

}