package com.slan.admin.ui.adapters.teams_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.R
import com.slan.admin.data.model.AllTeamsListData
import com.slan.admin.databinding.RvLayoutListAllTeamsBinding
import com.slan.admin.ui.fragment.teams.AllTeamsFragmentDirections

class AllTeamsRVAdapter: ListAdapter<AllTeamsListData, AllTeamsRVAdapter.AllTeamsViewHolder>(AllTeamsDiffCallBack()) {
    class AllTeamsViewHolder(private val binding: RvLayoutListAllTeamsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.tvBtHistory.setOnClickListener {
                val pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION) {

                    val item = itemId
                    val action =
                        AllTeamsFragmentDirections.actionNavigationTeamsToTeamProfileFragment()
                    it.findNavController().navigate(action)

                }
            }

            binding.tvTeamName.setOnClickListener {
                val pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    val item = itemId
                    val action =
                        AllTeamsFragmentDirections.actionNavigationTeamsToTeamMembersFragment()
                    it.findNavController().navigate(action)
                }
            }
        }
        fun bind(item: AllTeamsListData) {

            binding.tvTeamName.text = item.teamName
            binding.tvTeamOwnerName.text = item.teamOwnerName
            binding.tvTeamOwnerNumber.text = item.teamOwnerNumber
            when (item.sports) {
                "Cricket" ->binding.ivSportsLogo.setImageResource(R.drawable.cricket_logo)
                "Volleyball" ->binding.ivSportsLogo.setImageResource(R.drawable.ic_basketball_logo)
                "Badminton" ->binding.ivSportsLogo.setImageResource(R.drawable.ic_shuttlecock_logo)
                "Basketball" ->binding.ivSportsLogo.setImageResource(R.drawable.ic_basketball_logo)
                "Football" ->binding.ivSportsLogo.setImageResource(R.drawable.ic_football_logo)

            }


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): AllTeamsViewHolder {
        val binding = RvLayoutListAllTeamsBinding.inflate(
            LayoutInflater.from(parent.context) ,
            parent ,
            false
        )
        return AllTeamsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AllTeamsViewHolder , position: Int) {
        holder.bind(getItem(position))
    }


}

class AllTeamsDiffCallBack:DiffUtil.ItemCallback<AllTeamsListData>() {
    override fun areItemsTheSame(oldItem: AllTeamsListData , newItem: AllTeamsListData): Boolean {
        return oldItem.teamName == newItem.teamName
    }

    override fun areContentsTheSame(
        oldItem: AllTeamsListData ,
        newItem: AllTeamsListData
    ): Boolean {
        return oldItem == newItem

    }

}
