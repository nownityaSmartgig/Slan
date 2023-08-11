package com.slan.admin.ui.fragment.tournaments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.slan.admin.R
import com.slan.admin.data.source.local.CouponCodeDataSource
import com.slan.admin.databinding.DialogBoxCoupanBinding
import com.slan.admin.databinding.DialogBoxGeographyBinding
import com.slan.admin.databinding.DialogBoxPaymentMethodBinding
import com.slan.admin.databinding.FragmentDrawScreenBinding
import com.slan.admin.databinding.FragmentPaymentDetailsBinding
import com.slan.admin.ui.adapters.tournments_a.DialogCouponCodeRVAdapter

class PaymentDetailsFragment:Fragment() {

    private lateinit var binding:FragmentPaymentDetailsBinding
    private val dialogCouponAdapter=DialogCouponCodeRVAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentPaymentDetailsBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvCoupan.setOnClickListener {
            showDialogCoupanOption()
        }
        binding.tvGeography.setOnClickListener {
            showDialogGeographyOption()
        }
        binding.tvPaymentMode.setOnClickListener {
            showDialogPaymentModeOption()
        }




    }

    private fun showDialogCoupanOption(){
        val dialogBinding= DialogBoxCoupanBinding.inflate(LayoutInflater.from(requireContext()))
        val dialogBuilder= AlertDialog.Builder(requireContext(), R.style.CustomAlertDialogTheme).setView(dialogBinding.root)
        val alertDialog=dialogBuilder.create()


        val dialogDatasource = CouponCodeDataSource().loadCouponCodeDataSource()
        dialogBinding.rvCoupanList.adapter = dialogCouponAdapter
        dialogCouponAdapter.submitList(dialogDatasource)


        dialogBinding.btnOk.setOnClickListener {
            alertDialog.dismiss()
        }

        dialogBinding.btnCancel.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }

    private fun showDialogGeographyOption(){
        val dialogBinding= DialogBoxGeographyBinding.inflate(LayoutInflater.from(requireContext()))
        val dialogBuilder=AlertDialog.Builder(requireContext(),R.style.CustomAlertDialogTheme).setView(dialogBinding.root)
        val alertDialog=dialogBuilder.create()

        dialogBinding.btnOk.setOnClickListener {
            alertDialog.dismiss()
        }
        dialogBinding.btnCancel.setOnClickListener {
            alertDialog.dismiss()
        }
        alertDialog.show()
    }

    private fun showDialogPaymentModeOption(){
        val dialogBinding= DialogBoxPaymentMethodBinding.inflate(LayoutInflater.from(requireContext()))
        val dialogBuilder=AlertDialog.Builder(requireContext(),R.style.CustomAlertDialogTheme).setView(dialogBinding.root)
        val alertDialog=dialogBuilder.create()

        dialogBinding.btnOk.setOnClickListener {
            alertDialog.dismiss()
        }
        dialogBinding.btnCancel.setOnClickListener {
            alertDialog.dismiss()
        }
        alertDialog.show()
    }



}