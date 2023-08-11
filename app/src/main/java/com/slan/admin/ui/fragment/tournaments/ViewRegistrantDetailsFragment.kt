package com.slan.admin.ui.fragment.tournaments

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.DocumentsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.slan.admin.databinding.FragmentViewRegistrantDetailsBinding


class ViewRegistrantDetailsFragment:Fragment() {

    private lateinit var binding: FragmentViewRegistrantDetailsBinding

    private val pickPdfLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val pdfUri: Uri? = result.data?.data
                if (pdfUri != null) {
                    updatePdfTextView(pdfUri)
                }
            }
        }

    private val requestGalleryPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            isGranted ->
        if (isGranted) {
            openPdfFileManager()
        } else {
            showPermissionDenied()


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentViewRegistrantDetailsBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvClickToAdd.setOnClickListener{
            checkPdfPermission()
        }


    }


    private fun checkPdfPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            openPdfFileManager()
        } else {
            requestGalleryPermissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }
    private fun updatePdfTextView(pdfUri: Uri) {
        val displayName = getDisplayNameFromUri(pdfUri)
        binding.ivAdharCard.visibility=View.VISIBLE
        binding.tvFileName.visibility=View.VISIBLE
        binding.tvFileName.text = displayName
    }

    private fun openPdfFileManager() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "application/pdf" // Filter to show only PDF files
        pickPdfLauncher.launch(intent)
    }

    private fun showPermissionDenied() {
        AlertDialog.Builder(requireContext()).apply {
            setTitle("Permission Request")
            setMessage("This app requires permission to access PDF files.")
            setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            setNegativeButton("Cancel", null)
            setCancelable(false)
            show()
        }
    }

    private fun getDisplayNameFromUri(uri: Uri): String {
        val contentResolver = requireContext().contentResolver
        var displayName = "Unknown PDF"

        try {
            val cursor = contentResolver.query(uri, null, null, null, null)

            cursor?.use {
                if (it.moveToFirst()) {
                    val displayNameIndex = it.getColumnIndex(DocumentsContract.Document.COLUMN_DISPLAY_NAME)
                    if (displayNameIndex != -1) {
                        displayName = it.getString(displayNameIndex)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return displayName
    }





}