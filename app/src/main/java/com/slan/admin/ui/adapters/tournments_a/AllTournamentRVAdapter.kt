package com.slan.admin.ui.adapters.tournments_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.AllTournamentListData
import com.slan.admin.databinding.RvLayoutTournamentsListBinding
import com.slan.admin.ui.fragment.tournaments.AllTournamentsFragmentDirections

class AllTournamentRVAdapter:ListAdapter<AllTournamentListData,AllTournamentRVAdapter.AllTournamentViewHolder>(AllTournamentDiffCallback()) {
    class AllTournamentViewHolder(private val binding: RvLayoutTournamentsListBinding) :
        RecyclerView.ViewHolder(binding.root) {


        init {
            binding.clTournamentItem.setOnClickListener {
                val position = adapterPosition
                if (position!= RecyclerView.NO_POSITION) {
                    val action=AllTournamentsFragmentDirections.actionNavigationAllTournamentToTournamentsEvents()
                    it.findNavController().navigate(action)
                }
            }
        }
            fun bind(item: AllTournamentListData) {
                binding.tvheading.text = item.tournamentName

                binding.tvTournamentLocation.text=item.location
                val dateFrom = item.dateStart
                val dateTo = item.dateEnd
                binding.tvTournamentDate.text ="$dateFrom to $dateTo"

            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllTournamentViewHolder {
        val binding = RvLayoutTournamentsListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AllTournamentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AllTournamentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class AllTournamentDiffCallback : DiffUtil.ItemCallback<AllTournamentListData>() {
    override fun areItemsTheSame(
        oldItem: AllTournamentListData,
        newItem: AllTournamentListData
    ): Boolean {
        return oldItem.tournamentName==newItem.tournamentName
    }

    override fun areContentsTheSame(
        oldItem: AllTournamentListData,
        newItem: AllTournamentListData
    ): Boolean {
        return oldItem==newItem
    }


}
