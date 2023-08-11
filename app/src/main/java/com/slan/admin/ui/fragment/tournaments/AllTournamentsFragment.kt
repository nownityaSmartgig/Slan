package com.slan.admin.ui.fragment.tournaments

import android.os.Binder
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.slan.admin.R
import com.slan.admin.data.source.local.AllTournamentDataSource
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
    }

}