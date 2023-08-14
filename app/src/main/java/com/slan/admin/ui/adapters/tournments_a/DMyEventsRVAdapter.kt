package com.slan.admin.ui.adapters.tournments_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.DMyEventsListData
import com.slan.admin.databinding.RvLayoutEventsListBinding

class DMyEventsRVAdapter:ListAdapter<DMyEventsListData,DMyEventsRVAdapter.DMyEventsViewHolder> (DMyEventsDiffUtillCallBack()){
    class DMyEventsViewHolder(private val binding:RvLayoutEventsListBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(item:DMyEventsListData){
            binding.tvEventName.text=item.events
            binding.tvParticipantName.text=item.participants
            binding.tvAction.text=item.action

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DMyEventsViewHolder {
        val binding=RvLayoutEventsListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DMyEventsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DMyEventsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DMyEventsDiffUtillCallBack:DiffUtil.ItemCallback<DMyEventsListData>() {
    override fun areItemsTheSame(oldItem: DMyEventsListData, newItem: DMyEventsListData): Boolean {
        return oldItem.events==newItem.events
    }

    override fun areContentsTheSame(
        oldItem: DMyEventsListData,
        newItem: DMyEventsListData
    ): Boolean {
        return oldItem==newItem
    }

}
