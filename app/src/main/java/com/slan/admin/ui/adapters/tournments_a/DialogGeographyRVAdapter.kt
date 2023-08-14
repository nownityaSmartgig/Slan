package com.slan.admin.ui.adapters.tournments_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.DialogGeographyListData

import com.slan.admin.databinding.RvLayoutGeographyListBinding

class DialogGeographyRVAdapter:ListAdapter<DialogGeographyListData,DialogGeographyRVAdapter.DialogGeographyViewHolder>(DialogGeographyDiffUtillCallBack()) {
    class DialogGeographyViewHolder(private val binding:RvLayoutGeographyListBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(item:DialogGeographyListData){
            binding.tvState.text=item.State
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DialogGeographyViewHolder {
        val binding= RvLayoutGeographyListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DialogGeographyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: DialogGeographyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}

class DialogGeographyDiffUtillCallBack:DiffUtil.ItemCallback<DialogGeographyListData>() {
    override fun areItemsTheSame(
        oldItem: DialogGeographyListData,
        newItem: DialogGeographyListData
    ): Boolean {
        return oldItem.State==newItem.State
    }

    override fun areContentsTheSame(
        oldItem: DialogGeographyListData,
        newItem: DialogGeographyListData
    ): Boolean {
        return oldItem==newItem
    }

}
