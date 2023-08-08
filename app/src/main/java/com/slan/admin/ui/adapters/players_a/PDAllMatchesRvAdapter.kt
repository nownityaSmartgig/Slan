package com.slan.admin.ui.adapters.players_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.PDAllMatchesListData
import com.slan.admin.databinding.RvLayoutAllPlayersBinding
import com.slan.admin.databinding.RvLayoutPdAllMatchesListBinding

class PDAllMatchesRvAdapter :ListAdapter<PDAllMatchesListData, PDAllMatchesRvAdapter.PDAllMatchesViewHolder>(PDAllMatchesDiffCallCallBack()) {
    class PDAllMatchesViewHolder(private val binding: RvLayoutPdAllMatchesListBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: PDAllMatchesListData) {

            val date = "${item.startDate} to ${item.endDate}"
            binding.ivEventLogo.setImageResource(item.eventLogo)
            binding.tvTournamentName.text = item.tournamentName
            binding.tvTournamentName.text = date
            binding.tvTournamentName.text = item.location

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): PDAllMatchesViewHolder {
        val binding = RvLayoutPdAllMatchesListBinding.inflate(
            LayoutInflater.from(parent.context) ,
            parent ,
            false
        )
        return PDAllMatchesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PDAllMatchesViewHolder , position: Int) {
        holder.bind(getItem(position))
    }

}

class PDAllMatchesDiffCallCallBack:DiffUtil.ItemCallback<PDAllMatchesListData>() {
    override fun areItemsTheSame(
        oldItem: PDAllMatchesListData ,
        newItem: PDAllMatchesListData
    ): Boolean {
        return  oldItem.tournamentName == newItem.tournamentName
    }

    override fun areContentsTheSame(
        oldItem: PDAllMatchesListData ,
        newItem: PDAllMatchesListData
    ): Boolean {
        return oldItem == newItem
    }

}