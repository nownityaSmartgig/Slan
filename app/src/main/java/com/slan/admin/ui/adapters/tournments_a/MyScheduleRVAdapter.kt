package com.slan.admin.ui.adapters.tournments_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.ScheduleListData
import com.slan.admin.databinding.RvLayoutScheduleBinding

class MyScheduleRVAdapter:ListAdapter<ScheduleListData,MyScheduleRVAdapter.MyScheduleViewHolder>(MyScheduleDiffUtillCallBack()) {
    class MyScheduleViewHolder(private val binding: RvLayoutScheduleBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(item:ScheduleListData){
            binding.tvTeam1.text=item.Team1
            binding.tvTeam2.text=item.Team2
            val matchNo=item.MatchNo
            val groupNo=item.GroupNo
            binding.tvMatchNo.text="$matchNo,$groupNo"
            binding.tvMatchLocation.text=item.MatchLocation
            val date=item.Date
            val time=item.Time
            binding.tvMatchTime.text="$date-$time"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyScheduleViewHolder {
        val binding=RvLayoutScheduleBinding.inflate(LayoutInflater.from(parent.context))
        return MyScheduleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyScheduleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class MyScheduleDiffUtillCallBack :DiffUtil.ItemCallback<ScheduleListData>(){
    override fun areItemsTheSame(oldItem: ScheduleListData, newItem: ScheduleListData): Boolean {
        return oldItem.MatchNo==newItem.MatchNo
    }

    override fun areContentsTheSame(oldItem: ScheduleListData, newItem: ScheduleListData): Boolean {
        return oldItem==newItem
    }

}
