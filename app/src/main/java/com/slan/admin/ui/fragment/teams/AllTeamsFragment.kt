package com.slan.admin.ui.fragment.teams

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.slan.admin.R

class AllTeamsFragment : Fragment() {

    companion object {
        fun newInstance() = AllTeamsFragment()
    }

    private lateinit var viewModel: AllTeamsViewModel

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all_teams , container , false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AllTeamsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}