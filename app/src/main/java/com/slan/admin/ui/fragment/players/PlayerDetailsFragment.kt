package com.slan.admin.ui.fragment.players

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.slan.admin.R
import com.slan.admin.data.source.local.AllPlayerDataSource
import com.slan.admin.data.source.local.PDAllMatchesDataSource
import com.slan.admin.data.source.local.PDMyPartnerDataSource
import com.slan.admin.data.source.local.PDMyTeamsDataSource
import com.slan.admin.databinding.FragmentAllPlayersBinding
import com.slan.admin.databinding.FragmentPlayerDetailsBinding
import com.slan.admin.ui.adapters.players_a.PDAllMatchesRvAdapter
import com.slan.admin.ui.adapters.players_a.PDMyPartnerRVAdapter
import com.slan.admin.ui.adapters.players_a.PDMyTeamsRVAdapter

class PlayerDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = PlayerDetailsFragment()
    }

    private lateinit var viewModel: PlayerDetailsViewModel

    private lateinit var binding: FragmentPlayerDetailsBinding

    private val allMatchesAdapter = PDAllMatchesRvAdapter()
    private val myTeamsAdapter = PDMyTeamsRVAdapter()
    private val myPartnersAdapter = PDMyPartnerRVAdapter()

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayerDetailsBinding.inflate(inflater , container , false)

        return binding.root

    }

    private val requestGalleryPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                openGallery()
            } else {
                showPermissionDenied()
            }

        }

    private val pickImageLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val imageUri: Uri? = result.data?.data
                if (imageUri != null) {
                    binding.sivLogo.setImageURI(imageUri)

                } else {
                    val imageBitMap: Bitmap? = result.data?.extras?.get("data") as Bitmap

                }
            }

        }


//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(PlayerDetailsViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)


        val allMatchesDataSource = PDAllMatchesDataSource().loadPDAllMatchesDataSource()
        binding.rvAllMatches.adapter = allMatchesAdapter
        allMatchesAdapter.submitList(allMatchesDataSource)

        val myTeamsDataSource = PDMyTeamsDataSource().loadPDMyTeamsDataSource()
        binding.rvMyTeams.adapter = myTeamsAdapter
        myTeamsAdapter.submitList(myTeamsDataSource)

        val myPartnersDataSource = PDMyPartnerDataSource().loadPDMyPartnerDataSource()
        binding.rvMyPartner.adapter = myPartnersAdapter
        myPartnersAdapter.submitList(myPartnersDataSource)


        binding.sivLogo.setOnClickListener {
            checkGalleryPermission()
        }


    }

    private fun checkGalleryPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext() ,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            openGallery()
        } else {
            requestGalleryPermissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        pickImageLauncher.launch(intent)

    }

    private fun showPermissionDenied() {
        AlertDialog.Builder(requireContext()).apply {
            setTitle("Permission Request")
            setMessage("This App Required Permission to access gallery")
            setPositiveButton("OK") { dialog , _ ->
                dialog.dismiss()
            }
            setNegativeButton("Cancel" , null)
            setCancelable(false)
            show()
        }
    }


}