package com.slan.admin.ui.fragment.players

import android.app.DatePickerDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.slan.admin.R
import com.slan.admin.data.source.local.PlayerPaymentDataSource
import com.slan.admin.databinding.FragmentPlayerPaymentsBinding
import com.slan.admin.ui.adapters.players_a.PlayerPaymentsRVAdapter
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class PlayerPaymentsFragment : Fragment() {

    companion object {
        fun newInstance() = PlayerPaymentsFragment()
    }

    private lateinit var viewModel: PlayerPaymentsViewModel
    private lateinit var binding: FragmentPlayerPaymentsBinding

    private val playerPaymentsAdapter = PlayerPaymentsRVAdapter()
    private val dateFormatter = SimpleDateFormat("dd/MM/yyyy" , Locale.getDefault())
    private val calendar = Calendar.getInstance()


//    private val playerPaymentsAdapter =

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        binding=  FragmentPlayerPaymentsBinding.inflate(inflater,container,false)
        return binding.root

    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(PlayerPaymentsViewModel::class.java)
//        // TODO: Use the ViewModel
//    }


    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
//        val currentDate = SimpleDateFormat("dd/MM/yyyy" , Locale.getDefault()).format(Date())
////        binding.tvDateFrom.hint =currentDate
////        binding.tvDateTo.hint = currentDate



        /** Sorting Recyclerview on the basis of date will implement while api integration */
        binding.rlFrom.setOnClickListener {
            showFromDatePickerDialog()
        }
        binding.rlTo.setOnClickListener {
            showToDatePickerDialog()
        }


        val dataSource = PlayerPaymentDataSource().loadPlayerPaymentDataSource()
        binding.rvPlayerPayments.adapter = playerPaymentsAdapter
        playerPaymentsAdapter.submitList(dataSource)


    }

    private fun showFromDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(
            requireContext(),DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year , month , dayOfMonth)
                binding.tvDateFrom.text = dateFormatter.format(selectedDate.time)


            },calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH),

            )
        datePickerDialog.datePicker.maxDate = calendar.timeInMillis
        datePickerDialog.show()

    }
    private fun showToDatePickerDialog() {
        val fromDate = binding.tvDateFrom.text.toString()
        if (fromDate.isNotEmpty()) {
            val minDate = dateFormatter.parse(fromDate)
            val datePickerDialog = DatePickerDialog(
                requireContext() ,
                DatePickerDialog.OnDateSetListener { _ , year , month , dayOfMonth ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(year , month , dayOfMonth)
                    binding.tvDateTo.text = dateFormatter.format(selectedDate.time)
                } ,
                calendar.get(Calendar.YEAR) ,
                calendar.get(Calendar.MONTH) ,
                calendar.get(Calendar.DAY_OF_MONTH) ,
            )

            val calendarCopy = Calendar.getInstance()
            if (minDate != null) {
                calendarCopy.time = minDate
            }
            calendarCopy.add(Calendar.DAY_OF_MONTH ,+1)
            datePickerDialog.datePicker.minDate = calendarCopy.timeInMillis
            datePickerDialog.datePicker.maxDate = calendar.timeInMillis
            datePickerDialog.show()
        } else {
            Toast.makeText(requireContext() , "Select \"From Date\" First" , Toast.LENGTH_SHORT).show()
        }

    }

}
