package com.slan.admin.ui.adapters.tournments_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.PointListData
import com.slan.admin.databinding.RvLayoutPointsTableBinding

class MyPointsRVAdapter:ListAdapter<PointListData,MyPointsRVAdapter.MyPointsViewHolder>(MyPointsDiffUtillCallBack()) {
    class MyPointsViewHolder (private val binding: RvLayoutPointsTableBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:PointListData){
           binding.tvUsername.text==item.UserName
            binding.tvPlayedMatchesCount.text=item.TotalPlayedMatches
            binding.tvWinMatchesCount.text=item.MatchesWin
            binding.tvLossMatchesCount.text=item.MatchesLoss
            binding.tvPtsCount.text=item.Points
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPointsViewHolder {
        val binding = RvLayoutPointsTableBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyPointsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyPointsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class MyPointsDiffUtillCallBack:DiffUtil.ItemCallback<PointListData> (){
    override fun areItemsTheSame(oldItem: PointListData, newItem: PointListData): Boolean {
        return oldItem.UserName == newItem.UserName
    }

    override fun areContentsTheSame(oldItem: PointListData, newItem: PointListData): Boolean {
        return oldItem==newItem
    }

}
