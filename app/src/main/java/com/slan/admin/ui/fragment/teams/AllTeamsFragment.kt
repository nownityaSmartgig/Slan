package com.slan.admin.ui.fragment.teams

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.slan.admin.R
import com.slan.admin.data.source.local.AllTeamsDataSource
import com.slan.admin.databinding.FragmentAllTeamsBinding
import com.slan.admin.ui.adapters.teams_a.AllTeamsRVAdapter

class AllTeamsFragment : Fragment() {

    companion object {
        fun newInstance() = AllTeamsFragment()
    }

    private lateinit var viewModel: AllTeamsViewModel

    private lateinit var binding: FragmentAllTeamsBinding
    private val allTeamsAdapter =AllTeamsRVAdapter()

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
        binding.rvAllTeamsList.adapter = allTeamsAdapter
        allTeamsAdapter.submitList(dataSource)





    }

}