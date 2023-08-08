package com.slan.admin.ui.adapters.players_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.R
import com.slan.admin.data.model.PDMyTeamsListData
import com.slan.admin.databinding.RvLayoutPdMyTeamsBinding

class PDMyTeamsRVAdapter:
    ListAdapter<PDMyTeamsListData , PDMyTeamsRVAdapter.PDMyTeamsViewHolder>(PDMyTeamsDiffCallBack()){
    class PDMyTeamsViewHolder(private val binding: RvLayoutPdMyTeamsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PDMyTeamsListData) {
            binding.tvTeamName.text = item.teamName

            binding.tvSports.text = item.sport

            when (item.sport) {
                "Cricket" -> binding.ivGameLogo.setImageResource(R.drawable.cricket_logo)
                "Badminton" -> binding.ivGameLogo.setImageResource(R.drawable.ic_shuttlecock_logo)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): PDMyTeamsViewHolder {
        val binding = RvLayoutPdMyTeamsBinding.inflate(
            LayoutInflater.from(parent.context) , parent , false
        )
        return PDMyTeamsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PDMyTeamsViewHolder , position: Int) {
        holder.bind(getItem(position))
    }
}

class PDMyTeamsDiffCallBack:DiffUtil.ItemCallback<PDMyTeamsListData>() {
    override fun areItemsTheSame(oldItem: PDMyTeamsListData , newItem: PDMyTeamsListData): Boolean {
        return oldItem.teamName==newItem.teamName
    }

    override fun areContentsTheSame(
        oldItem: PDMyTeamsListData ,
        newItem: PDMyTeamsListData
    ): Boolean {
        return oldItem ==newItem
    }

}
