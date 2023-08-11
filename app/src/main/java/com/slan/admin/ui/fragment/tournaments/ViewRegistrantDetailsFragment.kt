package com.slan.admin.ui.fragment.tournaments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.slan.admin.databinding.FragmentViewRegistrantDetailsBinding


class ViewRegistrantDetailsFragment:Fragment() {

    private lateinit var binding: FragmentViewRegistrantDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentViewRegistrantDetailsBinding.inflate(inflater,container,false)

        return binding.root
    }



}