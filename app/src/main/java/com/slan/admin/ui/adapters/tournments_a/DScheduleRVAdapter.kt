package com.slan.admin.ui.adapters.tournments_a

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.DScheduleListData
import com.slan.admin.databinding.RvLayoutScheduleBinding
import com.slan.admin.databinding.RvLayoutTeamVsTeamScoreBinding

class DScheduleRVAdapter:ListAdapter<DScheduleListData,DScheduleRVAdapter.DScheduleViewHolder>(DScheduleDiffUtilCallback()) {
    class DScheduleViewHolder(val binding:RvLayoutTeamVsTeamScoreBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(data:DScheduleListData){
            binding.tvLeagueNameHeading.text = data.leaugeName
            binding.tvTeamOneName.text = data.team1
            binding.tvTeamTwoName.text = data.team2
            val match=data.matchNo
            val group=data.group
            binding.tvMatchNumber.text="$match Match,Group $group"
            val time=data.time
            val date=data.date
            binding.tvTournamentTimeDate.text="${date}-${time}/Local"
            binding.tvTournamentLocation.text=data.matchLocation

            binding.clScoreLayout.visibility= View.GONE
            binding.btnAddScore.visibility= View.GONE
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DScheduleViewHolder {
        val binding=RvLayoutTeamVsTeamScoreBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DScheduleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DScheduleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DScheduleDiffUtilCallback :DiffUtil.ItemCallback<DScheduleListData>(){
    override fun areItemsTheSame(oldItem: DScheduleListData, newItem: DScheduleListData): Boolean {
        return oldItem.leaugeName==newItem.leaugeName
    }

    override fun areContentsTheSame(
        oldItem: DScheduleListData,
        newItem: DScheduleListData
    ): Boolean {
        return oldItem==newItem
    }


}
