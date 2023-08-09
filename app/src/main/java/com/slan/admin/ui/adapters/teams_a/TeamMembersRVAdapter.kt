package com.slan.admin.ui.adapters.teams_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.TeamMembersListData
import com.slan.admin.databinding.RvLayoutTeamMembersDetailsBinding

class TeamMembersRVAdapter:ListAdapter<TeamMembersListData, TeamMembersRVAdapter.TeamMembersViewHolder>(TeamMembersDiffCallBack()) {
    class TeamMembersViewHolder(private val binding: RvLayoutTeamMembersDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TeamMembersListData) {

            binding.tvName.text = item.name
            binding.tvDob.text = item.dob
            binding.tvGender.text = item.gender
            binding.tvMobNum.text = item.mobileNumber

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): TeamMembersViewHolder {
        val binding = RvLayoutTeamMembersDetailsBinding.inflate(
            LayoutInflater.from(parent.context) ,
            parent ,
            false
        )

        return TeamMembersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamMembersViewHolder , position: Int) {
        holder.bind(getItem(position))
    }
}

class TeamMembersDiffCallBack:DiffUtil.ItemCallback<TeamMembersListData>() {
    override fun areItemsTheSame(
        oldItem: TeamMembersListData ,
        newItem: TeamMembersListData
    ): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: TeamMembersListData ,
        newItem: TeamMembersListData
    ): Boolean {
        return oldItem == newItem
    }

}
