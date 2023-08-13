package com.slan.admin.ui.fragment.tournaments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import com.slan.admin.R
import com.slan.admin.data.model.TSchedulesListData
import com.slan.admin.data.source.local.TSchedulesDataSource
import com.slan.admin.databinding.FragmentSchedulesBinding
import com.slan.admin.ui.adapters.tournments_a.SchedulesRVAdapter

class SchedulesFragment : Fragment() {

    companion object {
        fun newInstance() = SchedulesFragment()
    }

    private lateinit var viewModel: SchedulesViewModel
    private lateinit var binding: FragmentSchedulesBinding
    private val scheduleAdapter = SchedulesRVAdapter()
    private var originalList :List<TSchedulesListData> = emptyList()


    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSchedulesBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(SchedulesViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)


        val datasource = TSchedulesDataSource().loadTSchedulesDataSource()
        originalList = datasource
        binding.rvLeagueList.adapter = scheduleAdapter
        scheduleAdapter.submitList(originalList)

        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    newText?.let {
                        searchList(it)
                    }
                }else{
                    scheduleAdapter.submitList(originalList)
                }
                return true
            }
        })


    }

    private fun searchList(query: String) {
        val filterData = originalList.filter { list ->
            list.leagueName.contains(query , ignoreCase = true)
                    || list.teamsName.any { it.teamOne.contains(query, ignoreCase = true)|| it.teamTwo.contains(query, ignoreCase = true) }
                    || list.location.contains(query , ignoreCase = true)
        }
        scheduleAdapter.submitList(filterData)

    }

}