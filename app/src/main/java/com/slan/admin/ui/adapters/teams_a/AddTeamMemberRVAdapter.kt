package com.slan.admin.ui.adapters.teams_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.AddTeamMemberListData
import com.slan.admin.databinding.RvLayoutTeamMemberListBinding

class AddTeamMemberRVAdapter :
    ListAdapter<AddTeamMemberListData , AddTeamMemberRVAdapter.AddTeamMemberViewHolder>(
        AddTeamMemberDiffUtil()) {
    class AddTeamMemberViewHolder(private val binding: RvLayoutTeamMemberListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AddTeamMemberListData) {
            binding.tvName.text = item.name
            binding.tvPhoneNumber.text = item.mobileNumber

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): AddTeamMemberViewHolder {
        val binding = RvLayoutTeamMemberListBinding.inflate(
            LayoutInflater.from(parent.context) ,
            parent ,
            false
        )
        return AddTeamMemberViewHolder(binding)

    }

    override fun onBindViewHolder(holder: AddTeamMemberViewHolder , position: Int) {
        holder.bind(getItem(position))
    }
}

class AddTeamMemberDiffUtil : DiffUtil.ItemCallback<AddTeamMemberListData>() {
    override fun areItemsTheSame(
        oldItem: AddTeamMemberListData ,
        newItem: AddTeamMemberListData
    ): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: AddTeamMemberListData ,
        newItem: AddTeamMemberListData
    ): Boolean {
        return oldItem == newItem
    }


}
