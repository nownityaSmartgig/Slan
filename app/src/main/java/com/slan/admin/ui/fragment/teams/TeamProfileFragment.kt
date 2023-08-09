package com.slan.admin.ui.fragment.teams

import android.app.DatePickerDialog
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import com.slan.admin.R
import com.slan.admin.data.model.TeamProfileListData
import com.slan.admin.data.source.local.TeamProfileDataSource
import com.slan.admin.databinding.FragmentTeamProfileBinding
import com.slan.admin.ui.adapters.teams_a.TeamProfileRVAdapter
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class TeamProfileFragment : Fragment() {

    companion object {
        fun newInstance() = TeamProfileFragment()
    }

    private lateinit var viewModel: TeamProfileViewModel
    private lateinit var binding: FragmentTeamProfileBinding
    private val teamProfileAdapter = TeamProfileRVAdapter()

    private val dateFormatter = SimpleDateFormat("dd/MM/yyyy" , Locale.getDefault())
    private val calendar = Calendar.getInstance()


    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamProfileBinding.inflate(inflater , container , false)
        setHasOptionsMenu(true)
        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(TeamProfileViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)


        val dataSource = TeamProfileDataSource().loadTeamProfileDataSource()
        binding.rvTeamProfile.adapter = teamProfileAdapter
        teamProfileAdapter.submitList(dataSource)


        /** Sorting Recyclerview on the basis of date will implement while api integration */

        binding.rlFrom.setOnClickListener {
            showFromDatePickerDialog()
        }

        binding.rlTo.setOnClickListener {
            showToDatePickerDialog()
        }

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

    override fun onCreateOptionsMenu(menu: Menu , inflater: MenuInflater) {
        inflater.inflate(R.menu.team_profile_menu , menu)
//        val shareItem = menu.findItem(R.id.nav_search)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_share -> {
                shareDetails()

                true
            }

            else -> super.onOptionsItemSelected(item)

        }
    }

    private fun shareDetails() {
        Toast.makeText(requireContext() , "Share" , Toast.LENGTH_SHORT).show()
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        val shareText = "Slan Admin"
        shareIntent.putExtra(Intent.EXTRA_TEXT , shareText)
        startActivity(Intent.createChooser(shareIntent,"Share Details Via"))
    }

}