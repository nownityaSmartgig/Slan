package com.slan.admin.ui.adapters.tournments_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.AllLeagueListData
import com.slan.admin.databinding.RvLayoutTournamentsListBinding
import com.slan.admin.ui.fragment.tournaments.AllTournamentsFragmentDirections

class AllLeaguesRVAdapter:ListAdapter<AllLeagueListData,AllLeaguesRVAdapter.AllLeagueViewHolder>(AllLeagueDiffUtillCallBack) {



    class AllLeagueViewHolder(private val binding:RvLayoutTournamentsListBinding):RecyclerView.ViewHolder(binding.root) {
        init {
            binding.clTournamentItem.setOnClickListener {
                val position = adapterPosition
                if (position!= RecyclerView.NO_POSITION) {
                    val action= AllTournamentsFragmentDirections.actionNavigationAllTournamentToTournamentsEvents()
                    it.findNavController().navigate(action)
                }
            }
        }

        fun bind(data: AllLeagueListData) {
           binding.tvheading.text=data.tournamentName
            binding.tvTournamentLocation.text=data.location
            val dateFrom = data.dateStart
            val dateTo = data.dateEnd
            binding.tvTournamentDate.text="$dateFrom to $dateTo"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllLeagueViewHolder {
        val binding=RvLayoutTournamentsListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AllLeagueViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AllLeagueViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object AllLeagueDiffUtillCallBack:DiffUtil.ItemCallback<AllLeagueListData>() {
    override fun areItemsTheSame(oldItem: AllLeagueListData, newItem: AllLeagueListData): Boolean {
        return oldItem.tournamentName==newItem.tournamentName
    }

    override fun areContentsTheSame(
        oldItem: AllLeagueListData,
        newItem: AllLeagueListData
    ): Boolean {
       return oldItem==newItem
    }

}
