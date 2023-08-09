package com.slan.admin.ui.fragment.teams

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import com.slan.admin.R
import com.slan.admin.data.model.AllTeamsListData
import com.slan.admin.data.source.local.AllTeamsDataSource
import com.slan.admin.databinding.FragmentAllTeamsBinding
import com.slan.admin.ui.adapters.teams_a.AllTeamsRVAdapter

class AllTeamsFragment : Fragment() {

    companion object {
        fun newInstance() = AllTeamsFragment()
    }

    private lateinit var viewModel: AllTeamsViewModel

    private lateinit var binding: FragmentAllTeamsBinding
    private val allTeamsAdapter = AllTeamsRVAdapter()
    private var originalList :List<AllTeamsListData> = emptyList()

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


    }

    private fun searchList(query: String) {
        val filterData =originalList.filter { list ->
            list.teamName.contains(query , ignoreCase = true)
                    || list.teamOwnerName.contains(query , ignoreCase = true)
                    || list.teamOwnerNumber.contains(query , ignoreCase = true)
                    ||list.sports.contains(query , ignoreCase = true)
        }
        allTeamsAdapter.submitList(filterData)

    }


}