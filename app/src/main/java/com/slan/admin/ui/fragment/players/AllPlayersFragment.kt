package com.slan.admin.ui.fragment.players

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.slan.admin.R
import com.slan.admin.databinding.FragmentAllPlayersBinding

class AllPlayersFragment : Fragment() {

    companion object {
        fun newInstance() = AllPlayersFragment()
    }

    private lateinit var viewModel: AllPlayersViewModel
    private lateinit var binding: FragmentAllPlayersBinding

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllPlayersBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(AllPlayersViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)



    }
}