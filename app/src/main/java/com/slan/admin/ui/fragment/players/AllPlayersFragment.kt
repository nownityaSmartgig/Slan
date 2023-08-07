package com.slan.admin.ui.fragment.players

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.slan.admin.R

class AllPlayersFragment : Fragment() {

    companion object {
        fun newInstance() = AllPlayersFragment()
    }

    private lateinit var viewModel: AllPlayersViewModel

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all_players , container , false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AllPlayersViewModel::class.java)
        // TODO: Use the ViewModel
    }

}