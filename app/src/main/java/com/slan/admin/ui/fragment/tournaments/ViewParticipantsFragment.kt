package com.slan.admin.ui.fragment.tournaments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.slan.admin.data.source.local.ParticipantDataSource
import com.slan.admin.databinding.FragmentViewParticipantsBinding
import com.slan.admin.ui.adapters.tournments_a.MyParticipantListRVAdapter


class ViewParticipantsFragment : Fragment() {

    private lateinit var binding:FragmentViewParticipantsBinding
    private  val myParticipantListAdapter=MyParticipantListRVAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewParticipantsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvParticipantsList.adapter=myParticipantListAdapter
        val dataSource=ParticipantDataSource().loadAllParticipantDataSource()
        myParticipantListAdapter.submitList(dataSource)


    }


}