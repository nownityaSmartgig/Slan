package com.slan.admin.ui.fragment.tournaments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.slan.admin.databinding.FragmentDrawScreenBinding

class DrawScreenFragment:Fragment() {

    private lateinit var binding: FragmentDrawScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentDrawScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

}