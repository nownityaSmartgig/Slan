package com.slan.admin.ui.fragment.players

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.slan.admin.R

class PlayerPaymentsFragment : Fragment() {

    companion object {
        fun newInstance() = PlayerPaymentsFragment()
    }

    private lateinit var viewModel: PlayerPaymentsViewModel

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_player_payments , container , false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PlayerPaymentsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}