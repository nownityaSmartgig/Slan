package com.slan.admin.ui.fragment.teams

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.slan.admin.R
import com.slan.admin.data.source.local.TeamMemberDataSource
import com.slan.admin.databinding.FragmentTeamMembersBinding
import com.slan.admin.ui.adapters.teams_a.TeamMembersRVAdapter

class TeamMembersFragment : Fragment() {

    companion object {
        fun newInstance() = TeamMembersFragment()
    }

    private lateinit var viewModel: TeamMembersViewModel
    private lateinit var binding: FragmentTeamMembersBinding
    private val teamMembersAdapter= TeamMembersRVAdapter()

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamMembersBinding.inflate(inflater , container , false)

        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(TeamMembersViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        teamMembersRVAdapterBinding()

        binding.tvBtAdd.setOnClickListener {
            val action =
                TeamMembersFragmentDirections.actionTeamMembersFragmentToAddTeamMemberFragment()
            it.findNavController().navigate(action)

        }

    }

    private fun teamMembersRVAdapterBinding() {
        val dataSource = TeamMemberDataSource().loadTeamMemberDataSource()
        binding.rvTeamMembersList.adapter = teamMembersAdapter
        teamMembersAdapter.submitList(dataSource)
    }

}