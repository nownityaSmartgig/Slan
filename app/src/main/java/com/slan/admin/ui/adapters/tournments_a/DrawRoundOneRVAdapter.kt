package com.slan.admin.ui.adapters.tournments_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.MatchesListData
import com.slan.admin.databinding.RvLayoutRound1Binding

class DrawRoundOneRVAdapter:ListAdapter<MatchesListData,DrawRoundOneRVAdapter.DrawRoundOneViewHolder>(DrawRoundOneDiffUtillCallBack()) {
    class DrawRoundOneViewHolder(private val binding:RvLayoutRound1Binding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MatchesListData) {
            binding.tvPlayer1.text=item.players[0].player_1
            binding.tvPlayer2.text=item.players[0].player_2
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrawRoundOneViewHolder {
        val binding=RvLayoutRound1Binding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DrawRoundOneViewHolder(binding)


    }

    override fun onBindViewHolder(holder: DrawRoundOneViewHolder, position: Int) {
       holder.bind(getItem(position))

    }

}

class DrawRoundOneDiffUtillCallBack : DiffUtil.ItemCallback<MatchesListData> (){
    override fun areItemsTheSame(oldItem: MatchesListData, newItem: MatchesListData): Boolean {
        return oldItem.players==newItem.players
    }

    override fun areContentsTheSame(oldItem: MatchesListData, newItem: MatchesListData): Boolean {
        return oldItem==newItem
    }


}
