package com.slan.admin.ui.fragment.tournaments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.source.local.EventDataSource
import com.slan.admin.databinding.FragmentTournamentsEventsBinding
import com.slan.admin.ui.adapters.tournments_a.MyEventListRVAdapter


class TournamentsEventsFragment : Fragment() {

    private lateinit var binding:FragmentTournamentsEventsBinding
    private val eventListAdapter = MyEventListRVAdapter()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentTournamentsEventsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.btViewDetails.setOnClickListener {
            val actions=TournamentsEventsFragmentDirections.actionTournamentsEventsToPaymentDetailsFragment()
            it.findNavController().navigate(actions)

        }

        binding.rvLayoutEventsList.adapter=eventListAdapter
        val dataSource=EventDataSource().loadAllEventDataSource()
        eventListAdapter.submitList(dataSource)



    }


}