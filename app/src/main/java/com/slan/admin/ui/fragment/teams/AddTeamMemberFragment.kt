package com.slan.admin.ui.fragment.teams

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.slan.admin.R
import com.slan.admin.data.source.local.AddTeamMemberDataSource
import com.slan.admin.databinding.DialogBoxPlayerRoleBinding
import com.slan.admin.databinding.FragmentAddTeamMemberBinding
import com.slan.admin.ui.adapters.teams_a.AddTeamMemberRVAdapter
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddTeamMemberFragment : Fragment() {

    companion object {
        fun newInstance() = AddTeamMemberFragment()
    }

    private lateinit var viewModel: AddTeamMemberViewModel
    private lateinit var binding: FragmentAddTeamMemberBinding
    private val addTeamMemberAdapter = AddTeamMemberRVAdapter()

    private var selectedPlayerRole: String? = null

    private val dateFormatter = SimpleDateFormat("dd/MM/yyyy" , Locale.getDefault())
    private val calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTeamMemberBinding.inflate(inflater,container,false)
        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(AddTeamMemberViewModel::class.java)
//        // TODO: Use the ViewModel
//    }


    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        val dataSource = AddTeamMemberDataSource().loadAddTeamMemberDataSource()
        binding.rvTeamMemberList.adapter = addTeamMemberAdapter
        addTeamMemberAdapter.submitList(dataSource)

        binding.tvDob.setOnClickListener {
            dobCalendar()



        }

        binding.btnSave.setOnClickListener {

            if (validation()) {
                val action =
                    AddTeamMemberFragmentDirections.actionAddTeamMemberFragmentToTeamMembersFragment()
                it.findNavController().navigate(action)
            } else {
                Toast.makeText(requireContext() , "Validation Error" , Toast.LENGTH_SHORT).show()
            }



        }


        binding.tvTeamPlayer.setOnClickListener {

            playerRoleDialog()


        }
    }

    private fun playerRoleDialog() {
        val dialogBoxBinding = DialogBoxPlayerRoleBinding.inflate(layoutInflater)
        val dialogView = dialogBoxBinding.root
        val dialogBox = Dialog(requireContext())
        dialogBox.setContentView(dialogView)
        // For round corners
        dialogBox.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        when (selectedPlayerRole) {
            "Captain" -> dialogBoxBinding.rbCaptain.isChecked = true
            "Vice Captain" -> dialogBoxBinding.rbViceCaptain.isChecked = true
            "Team Player" -> dialogBoxBinding.rbTeamPlayer.isChecked = true
        }

        dialogBoxBinding.rbCaptain.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedPlayerRole = ("Captain")
            }
        }

        dialogBoxBinding.rbViceCaptain.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedPlayerRole = ("Vice Captain")
            }
        }

        dialogBoxBinding.rbTeamPlayer.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedPlayerRole = ("Team Player")
            }
        }

        dialogBoxBinding.tvBtCancel.setOnClickListener {
            dialogBox.dismiss()

        }

        dialogBoxBinding.tvBtOk.setOnClickListener {
            if (!selectedPlayerRole.isNullOrEmpty()) {
                binding.tvTeamPlayer.text = selectedPlayerRole.toString()
                toastView(selectedPlayerRole!!)
            }

            dialogBox.dismiss()

        }

        dialogBox.show()
    }

//    private fun toastView(text:String) {
//        Toast.makeText(requireContext() , text , Toast.LENGTH_SHORT).show()
//    }

    private fun toastView(text: String?) {
        text?.let {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }



    private fun dobCalendar() {
        val maxdate = Calendar.getInstance()
        maxdate.add(Calendar.YEAR , -1)
        val datePickerDialog = DatePickerDialog(
            requireContext() ,
            DatePickerDialog.OnDateSetListener { _ , year , month , dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year , month , dayOfMonth)
                binding.tvDob.text = dateFormatter.format(selectedDate.time)


            } ,
            calendar.get(Calendar.YEAR) ,
            calendar.get(Calendar.MONTH) ,
            calendar.get(Calendar.DAY_OF_MONTH) ,
        )
        datePickerDialog.datePicker.maxDate = maxdate.timeInMillis
        datePickerDialog.show()
    }

    private fun validation(): Boolean {
        val name = binding.etName.text.toString()
        val phoneNumber = binding.etNumber.text.toString()
        val dob = binding.tvDob.text.toString()

        if (TextUtils.isEmpty(name)) {
            binding.etName.error = getString(R.string.enter_name)
            return false

        }

        if (TextUtils.isEmpty(name)) {
            binding.etNumber.error = getString(R.string.enter_mobile_number)
            return false

        }

        if (TextUtils.isEmpty(name)) {
            binding.tvDob.error = getString(R.string.enter_dob)
            return false

        }

        val phoneNumRegex = "^[0-9]{10}$"
        if (!phoneNumber.matches(Regex(phoneNumRegex))) {
            binding.etNumber.error = getString(R.string.enter_valid_mobile_number)
            return false
        }

        val dobRegex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\$"
        if (!dob.matches(Regex(dobRegex))) {
            binding.tvDob.error = getString(R.string.invalid_dob_format)
            return false
        }

        return true

    }


}