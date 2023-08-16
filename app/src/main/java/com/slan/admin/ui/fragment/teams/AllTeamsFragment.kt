package com.slan.admin.ui.fragment.teams

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.slan.admin.R
import com.slan.admin.data.model.AllTeamsListData
import com.slan.admin.data.source.local.AllTeamsDataSource
import com.slan.admin.data.source.local.SportsDialogDataSource
import com.slan.admin.databinding.DialogBoxPlayerTypeBinding
import com.slan.admin.databinding.DialogboxSportsBinding
import com.slan.admin.databinding.FragmentAllTeamsBinding
import com.slan.admin.ui.adapters.teams_a.AllTeamsRVAdapter
import com.slan.admin.ui.adapters.teams_a.CustomCallBackInterface
import com.slan.admin.ui.adapters.teams_a.SportsDialogRvAdapter

class AllTeamsFragment : Fragment() , CustomCallBackInterface {

    companion object {
        fun newInstance() = AllTeamsFragment()
    }

    private lateinit var viewModel: AllTeamsViewModel

    private lateinit var binding: FragmentAllTeamsBinding
    private val allTeamsAdapter = AllTeamsRVAdapter()
    private var originalList: List<AllTeamsListData> = emptyList()

    private var selectedPlayerType: String? = null
//    private var selectedSportsId: Int? = null
    private var selectedSportsId: String? = null
    private val adapter = SportsDialogRvAdapter(this)


    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllTeamsBinding.inflate(inflater , container , false)

        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(AllTeamsViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //  get a reference to the activity
//        (activity as AppCompatActivity).apply {
//            title = "All Teams"
//
//        }




    }



    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        val dataSource = AllTeamsDataSource().loadAllTeamsDataSource()
        originalList = dataSource
        binding.rvAllTeamsList.adapter = allTeamsAdapter
        allTeamsAdapter.submitList(originalList)

        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    newText?.let {
                        searchList(it)
                    }
                } else {
                    allTeamsAdapter.submitList(originalList)
                }
                return true

            }
        })

        binding.tvSportsFilter.setOnClickListener {
            sportsTypeDialogBox()
        }

        binding.tvTypesFilter.setOnClickListener {
            playerTypesDialogBox()
        }

    }

    private fun playerTypesDialogBox() {
        val dialogBoxBinding = DialogBoxPlayerTypeBinding.inflate(layoutInflater)
        val dialogView = dialogBoxBinding.root
        val dialogBox = Dialog(requireContext())
        dialogBox.setContentView(dialogView)
        dialogBox.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        when (selectedPlayerType) {
            "All" -> dialogBoxBinding.rbAll.isChecked = true
            "Kid" -> dialogBoxBinding.rbKid.isChecked = true
        }

        dialogBoxBinding.rbAll.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked) {
                selectedPlayerType = "All"
            }
        }


        dialogBoxBinding.rbKid.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked) {
                selectedPlayerType = "Kid"
            }
        }


        dialogBoxBinding.tvBtCancel.setOnClickListener {
            dialogBox.dismiss()
        }

        dialogBoxBinding.tvBtOk.setOnClickListener {
            if (!selectedPlayerType.isNullOrEmpty()) {
                binding.tvTypesFilter.text = selectedPlayerType.toString()
//                toastView(selectedPlayerType!!)

            }
            dialogBox.dismiss()
        }

        dialogBox.show()


    }

    private fun toastView(text: String?) {
        text?.let {
            Toast.makeText(requireContext() , it , Toast.LENGTH_SHORT).show()
        }
    }

    private fun sportsTypeDialogBox() {
        val dialogBoxBinding = DialogboxSportsBinding.inflate(layoutInflater)
        val dialogView = dialogBoxBinding.root
        val dialogBox = Dialog(requireContext())
        dialogBox.setContentView(dialogView)

        // Load data from SportsDialogDataSource
//        val dataSource = SportsDialogDataSource().loadSportsDialogDataSource()
//
//        dialogBoxBinding.rvSportsList.adapter = adapter
//        val lastSelectedIndex = adapter.getSelectedId()
//        if (lastSelectedIndex != null) {
//            adapter.setSelectedItem(lastSelectedIndex)
//        }
//
//        adapter.submitList(dataSource)

        // set the selected sports if  available
//        selectedSportsId?.let {sportsId ->
//            adapter.setSelectedItem(sportsId)

//        }

        when (selectedSportsId) {

            "All" -> dialogBoxBinding.rbAll.isChecked = true
            "Tennis" -> dialogBoxBinding.rbTennis.isChecked = true
            "Cricket" -> dialogBoxBinding.rbCricket.isChecked = true
            "Football" -> dialogBoxBinding.rbFootball.isChecked = true
            "Volleyball" -> dialogBoxBinding.rbVolleyball.isChecked = true
        }

        dialogBoxBinding.rbAll.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked) {
                selectedSportsId = "All"
            }
        }

        dialogBoxBinding.tvBtOk.setOnClickListener {

            // Update the selected Sports Id
//            selectedSportsId = adapter.getSelectedId()

//            selectedSportsId?.let { sportsId ->
//                adapter.setSelectedItem(sportsId)
//            }

            // Using selectedSportsId to update the UI
//            val selectedSports = dataSource.find {
//                it.id == selectedSportsId
//            }
//
//            if (selectedSports != null) {
//                binding.tvSportsFilter.text = selectedSports.sportsName
//            } else {
//                binding.tvSportsFilter.text = "Sport"
//            }

//            binding.tvSportsFilter.text= selectedSports?.sportsName?:"Sport"

//            toastView(selectedSports?.toString())


            if (!selectedSportsId.isNullOrEmpty()) {
                binding.tvTypesFilter.text = selectedSportsId.toString()
//                toastView(selectedPlayerType!!)

            }

            dialogBox.dismiss()

        }

        dialogBoxBinding.tvBtCancel.setOnClickListener {
            dialogBox.dismiss()
        }

        dialogBox.show()


    }

    private fun searchList(query: String) {
        val filterData = originalList.filter { list ->
            list.teamName.contains(query , ignoreCase = true)
                    || list.teamOwnerName.contains(query , ignoreCase = true)
                    || list.teamOwnerNumber.contains(query , ignoreCase = true)
                    || list.sports.contains(query , ignoreCase = true)
        }
        allTeamsAdapter.submitList(filterData)

    }

    override fun returnedItemFromAdapter(selectedItemIndex: Int) {
//        val aa = adapter.setSelectedItem(selcItemIndex)
//        Log.v("TestTheBox" , aa.toString())
//        Log.d("TestTheBox" , aa.toString())

        Log.d("AllTeamsFragment", "selectedItemIndex: $selectedItemIndex")
        adapter.setSelectedItem(selectedItemIndex)
        val aa = adapter.getSelectedId()
        Log.v("AllTeamsFragment", "selectedId from adapter: $aa")
    }

//    package:com.slan.admin





}