package com.slan.admin.ui.fragment.players

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.slan.admin.R
import com.slan.admin.databinding.FragmentAllPlayersBinding
import com.slan.admin.databinding.FragmentPlayerDetailsBinding

class PlayerDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = PlayerDetailsFragment()
    }

    private lateinit var viewModel: PlayerDetailsViewModel

    private lateinit var binding: FragmentPlayerDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayerDetailsBinding.inflate(layoutInflater , container , false)

//        val callback= requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object : OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
//                if (isEnabled) {
//                    findNavController().navigateUp()
//                }
//            }
//        })


//        val callback = object : OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
//                findNavController().navigateUp()
//            }
//        }
//
//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner , callback)
//        callback.remove()
//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        return binding.root

    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(PlayerDetailsViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

    }

}