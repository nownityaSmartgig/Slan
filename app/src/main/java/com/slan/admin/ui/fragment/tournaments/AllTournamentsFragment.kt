package com.slan.admin.ui.fragment.tournaments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.slan.admin.R
import com.slan.admin.data.source.local.AllLeagueDataSource
import com.slan.admin.data.source.local.AllTournamentDataSource
import com.slan.admin.databinding.DialogBoxSelectOptionBinding
import com.slan.admin.databinding.DialogBoxSportTypesBinding
import com.slan.admin.databinding.FragmentAllTournamentsBinding
import com.slan.admin.ui.adapters.tournments_a.AllLeaguesRVAdapter
import com.slan.admin.ui.adapters.tournments_a.AllTournamentRVAdapter

class AllTournamentsFragment : Fragment() {


    companion object {
        fun newInstance() = AllTournamentsFragment()
    }
    private lateinit var viewModel: AllTournamentsViewModel

    private lateinit var binding: FragmentAllTournamentsBinding
    private val allTournamentAdapter=AllTournamentRVAdapter()
    private val allLeagueAdapter=AllLeaguesRVAdapter()

    private var playerType:String?="Current"
    private var sportsType:String?="All"

    private var playerLeagueType:String?="Current"
    private var sportsLeagueType:String?="All"



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

        binding.layoutSportsList.rvTournamentList.adapter = allTournamentAdapter
        val dataSource = AllTournamentDataSource().loadAllTournamentDataSource()
        allTournamentAdapter.submitList(dataSource)

        binding.layoutLeagueList.rvTournamentList.adapter = allLeagueAdapter
        val leagueDataSource=AllLeagueDataSource().loadAllLeagueDataSource()
        allLeagueAdapter.submitList(leagueDataSource)

        binding.btTournament.setOnClickListener{
            binding.layoutSportsList.clSportList.visibility=View.VISIBLE
            binding.layoutLeagueList.clLeagueList.visibility=View.GONE

            binding.btTournament.setBackgroundResource(R.drawable.orange_left)
            binding.btLeague.setBackgroundResource(R.drawable.orange_right_border)

            binding.btTournament.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            binding.btLeague.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
        }

        binding.layoutSportsList.tvCurrent.setOnClickListener {
            showDialogSelectOption()
        }

        binding.layoutSportsList.tvSport.setOnClickListener {
            showDialogSportSelection()
        }

        binding.btLeague.setOnClickListener {
            binding.layoutSportsList.clSportList.visibility=View.GONE
            binding.layoutLeagueList.clLeagueList.visibility=View.VISIBLE

            binding.btTournament.setBackgroundResource(R.drawable.orange_left_border)
            binding.btLeague.setBackgroundResource(R.drawable.orange_right)

            binding.btTournament.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            binding.btLeague.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

        }

        binding.layoutLeagueList.tvCurrent.setOnClickListener {
            showDialogLeagueSelectOption()
        }

        binding.layoutLeagueList.tvSport.setOnClickListener {
            showDialogLeagueSportSelection()
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
                binding.layoutSportsList.tvSport.text=sportsType.toString()
            }

            alertDialog.dismiss()

        }
        dialogBinding.btnCancel.setOnClickListener{
            alertDialog.dismiss()
        }

        alertDialog.show()
    }

    private fun showDialogSelectOption() {
        val dialogSelectBinding= DialogBoxSelectOptionBinding.inflate(LayoutInflater.from(requireContext()))
        val dialogBuilder=AlertDialog.Builder(requireContext()).setView(dialogSelectBinding.root)
        val alertDialog=dialogBuilder.create()

        when (playerType) {
            "All"->dialogSelectBinding.radioAll.isChecked=true
            "Current"->dialogSelectBinding.radioCurrent.isChecked=true
        }

        dialogSelectBinding.radioAll.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                playerType="All"
            }
        }

        dialogSelectBinding.radioCurrent.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                playerType="Current"
            }
        }

        dialogSelectBinding.btnOk.setOnClickListener{
//            val radioGroup=dialogSelectBinding.rgSelectOption
//            val checkedRadioButtonId=radioGroup.checkedRadioButtonId
//            val checkedButton:RadioButton=dialogSelectBinding.rgSelectOption.findViewById(checkedRadioButtonId)
//            binding.tvCurrent.text=checkedButton.text.toString()

            if (!playerType.isNullOrEmpty()) {
                binding.layoutSportsList.tvCurrent.text=playerType.toString()
            }


//            if(!sportsType.isNullOrEmpty())

            alertDialog.dismiss()
        }
        dialogSelectBinding.btnCancel.setOnClickListener{
            alertDialog.dismiss()
        }

        alertDialog.show()

    }

    private fun showDialogLeagueSportSelection() {

        val dialogBinding = DialogBoxSportTypesBinding.inflate(LayoutInflater.from(requireContext()))
        val dialogBuilder = AlertDialog.Builder(requireContext()).setView(dialogBinding.root)
        val alertDialog = dialogBuilder.create()

        when(sportsLeagueType){
            "All"->dialogBinding.radioAll.isChecked=true
            "Tennis"->dialogBinding.radioTennis.isChecked=true
            "Cricket"->dialogBinding.radioCricket.isChecked=true
            "Football"->dialogBinding.radioFootball.isChecked=true
            "Volleyball"->dialogBinding.radioVolleyball.isChecked=true
        }

        dialogBinding.radioAll.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                sportsLeagueType="All"
            }
        }
        dialogBinding.radioTennis.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                sportsLeagueType="Tennis"
            }
        }
        dialogBinding.radioCricket.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                sportsLeagueType="Cricket"
            }
        }
        dialogBinding.radioFootball.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                sportsLeagueType="Football"
            }
        }
        dialogBinding.radioVolleyball.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                sportsLeagueType="Volleyball"
            }
        }
        dialogBinding.btnOk.setOnClickListener{
//            val radioGroup: RadioGroup =dialogBinding.rgSportsType
//            val checkedRadioButtonId= radioGroup.checkedRadioButtonId
//            val checkedButton: RadioButton =dialogBinding.rgSportsType.findViewById(checkedRadioButtonId)
//            binding.tvSport.text=checkedButton.text.toString()

            if (!sportsLeagueType.isNullOrEmpty()) {
                binding.layoutSportsList.tvSport.text=sportsLeagueType.toString()
            }

            alertDialog.dismiss()

        }
        dialogBinding.btnCancel.setOnClickListener{
            alertDialog.dismiss()
        }

        alertDialog.show()
    }

    private fun showDialogLeagueSelectOption() {
        val dialogSelectBinding= DialogBoxSelectOptionBinding.inflate(LayoutInflater.from(requireContext()))
        val dialogBuilder=AlertDialog.Builder(requireContext()).setView(dialogSelectBinding.root)
        val alertDialog=dialogBuilder.create()

        when (playerLeagueType) {
            "All"->dialogSelectBinding.radioAll.isChecked=true
            "Current"->dialogSelectBinding.radioCurrent.isChecked=true
        }

        dialogSelectBinding.radioAll.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                playerLeagueType="All"
            }
        }

        dialogSelectBinding.radioCurrent.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                playerLeagueType="Current"
            }
        }

        dialogSelectBinding.btnOk.setOnClickListener{
//            val radioGroup=dialogSelectBinding.rgSelectOption
//            val checkedRadioButtonId=radioGroup.checkedRadioButtonId
//            val checkedButton:RadioButton=dialogSelectBinding.rgSelectOption.findViewById(checkedRadioButtonId)
//            binding.tvCurrent.text=checkedButton.text.toString()

            if (!playerLeagueType.isNullOrEmpty()) {
                binding.layoutSportsList.tvCurrent.text=playerLeagueType.toString()
            }


//            if(!sportsType.isNullOrEmpty())

            alertDialog.dismiss()
        }
        dialogSelectBinding.btnCancel.setOnClickListener{
            alertDialog.dismiss()
        }

        alertDialog.show()

    }

}