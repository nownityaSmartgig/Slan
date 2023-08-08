package com.slan.admin.ui.fragment.teams

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.slan.admin.R

class AddTeamMemberFragment : Fragment() {

    companion object {
        fun newInstance() = AddTeamMemberFragment()
    }

    private lateinit var viewModel: AddTeamMemberViewModel

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_team_member , container , false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddTeamMemberViewModel::class.java)
        // TODO: Use the ViewModel
    }

}