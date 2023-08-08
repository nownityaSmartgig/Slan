package com.slan.admin.ui.fragment.players

import android.app.DatePickerDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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



        binding.rlFrom.setOnClickListener {
            showDatePickerDialog(binding.tvDateFrom)
//            showDatePickerDialog2(binding.tvDateFrom)
//            showDatePickerDialog3(binding.tvDateFrom,binding.tvFromDate)
        }
        binding.rlTo.setOnClickListener {
            showDatePickerDialog(binding.tvDateTo)
//            showDatePickerDialog2(binding.tvDateTo)
//            showDatePickerDialog3(binding.tvDateTo,binding.tvFromDate)
        }


        val dataSource = PlayerPaymentDataSource().loadPlayerPaymentDataSource()
        binding.rvPlayerPayments.adapter = playerPaymentsAdapter
        playerPaymentsAdapter.submitList(dataSource)


    }

    private fun showDatePickerDialog(textView: TextView) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),DatePickerDialog.OnDateSetListener { _,selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "${selectedDay}/${selectedMonth+1}/${selectedYear}"
                textView.text = selectedDate

            },year,month,day
        )
        datePickerDialog.datePicker.maxDate = calendar.timeInMillis

        datePickerDialog.show()
    }


    private fun showDatePickerDialog2(textView: TextView, fromDate:TextView) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),DatePickerDialog.OnDateSetListener { _,selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "${selectedDay}/${selectedMonth+1}/${selectedYear}"
                textView.text = selectedDate

            },year,month,day
        )
        datePickerDialog.datePicker.maxDate = calendar.timeInMillis

        if (!fromDate.text.isNullOrEmpty()) {
//            val fromDateParts = fromDate.text.toString().split("/")
            val fromDateParts = fromDate.text.toString().split("/")

            val fromDay= fromDateParts[0].toInt()
            val fromMonth= fromDateParts[1].toInt()-1
            val fromYear = fromDateParts[2].toInt()


            val minDateCalendar=Calendar.getInstance().apply {
                set(Calendar.DAY_OF_MONTH,fromDay)
                set(Calendar.MONTH,fromMonth)
                set(Calendar.YEAR,fromYear)
            }
            datePickerDialog.datePicker.minDate = minDateCalendar.timeInMillis
        }

        datePickerDialog.show()
    }

    private fun showDatePickerDialog3(textView: TextView, otherDateView: TextView) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(), DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "${selectedDay}/${selectedMonth + 1}/${selectedYear}"
                textView.text = selectedDate
            }, year, month, day
        )
        datePickerDialog.datePicker.maxDate = calendar.timeInMillis

        if (!otherDateView.text.isNullOrEmpty()) {
            val otherDateParts = otherDateView.text.toString().split("/")
            if (otherDateParts.size == 3) {
                val fromDay = otherDateParts[0].toInt()
                val fromMonth = otherDateParts[1].toInt() - 1
                val fromYear = otherDateParts[2].toInt()

                val minDateCalendar = Calendar.getInstance().apply {
                    set(Calendar.DAY_OF_MONTH, fromDay)
                    set(Calendar.MONTH, fromMonth)
                    set(Calendar.YEAR, fromYear)
                }
                datePickerDialog.datePicker.minDate = minDateCalendar.timeInMillis
            }
        }

        datePickerDialog.show()
    }

}
