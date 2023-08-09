package com.slan.admin.ui.fragment.tournaments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.slan.admin.R

class SchedulesFragment : Fragment() {

    companion object {
        fun newInstance() = SchedulesFragment()
    }

    private lateinit var viewModel: SchedulesViewModel

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_schedules , container , false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SchedulesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}