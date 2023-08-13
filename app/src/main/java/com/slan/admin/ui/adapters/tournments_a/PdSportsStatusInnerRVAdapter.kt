package com.slan.admin.ui.adapters.tournments_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.PDSportsStatusDataList
import com.slan.admin.databinding.RvLayoutPdGameListBinding

class PdSportsStatusInnerRVAdapter :
    ListAdapter<PDSportsStatusDataList, PdSportsStatusInnerRVAdapter.PdSportsStatusViewHolder>(
        PdSportsStatusDiffUtilCallBack()

    ) {
    inner class PdSportsStatusViewHolder(private val binding: RvLayoutPdGameListBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: PDSportsStatusDataList) {

            binding.tvStatus.text = item.status
            binding.tvAmtPaid.text = item.amtPaid
            binding.tvAmtToBePaid.text = item.amtToBePad

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PdSportsStatusViewHolder {
        val binding =
            RvLayoutPdGameListBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return PdSportsStatusViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PdSportsStatusViewHolder , position: Int) {
        holder.bind(getItem(position))

    }
}

class PdSportsStatusDiffUtilCallBack : DiffUtil.ItemCallback<PDSportsStatusDataList>() {
    override fun areItemsTheSame(
        oldItem: PDSportsStatusDataList ,
        newItem: PDSportsStatusDataList
    ): Boolean {
        return oldItem.status == newItem.status
    }

    override fun areContentsTheSame(
        oldItem: PDSportsStatusDataList ,
        newItem: PDSportsStatusDataList
    ): Boolean {
        return oldItem == newItem
    }


}
