package com.slan.admin.ui.adapters.tournments_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.PDSportsNameListData
import com.slan.admin.data.source.local.PDSportsDataSource
import com.slan.admin.databinding.RvLayoutPdGameHeadingListBinding

class PdSportsHeadingOuterRVAdapter :
    ListAdapter<PDSportsNameListData, PdSportsHeadingOuterRVAdapter.PdSportsHeadingOuterViewHolder>(
        PdSportsHeadingOuterDiffUtilCallBack()

    ) {
    inner class PdSportsHeadingOuterViewHolder(private val binding: RvLayoutPdGameHeadingListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val innerItemAdapter = PdSportsStatusInnerRVAdapter()
        private val dataSource = PDSportsDataSource().loadPDSportsStatusDataList()

        init {
            binding.rvSportsStausInner.adapter = innerItemAdapter

        }

        fun bind(item: PDSportsNameListData) {
            binding.tvSportsName.text = item.sportName

            innerItemAdapter.submitList(dataSource)

        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup ,
        viewType: Int
    ): PdSportsHeadingOuterRVAdapter.PdSportsHeadingOuterViewHolder {
        val binding = RvLayoutPdGameHeadingListBinding.inflate(
            LayoutInflater.from(parent.context) ,
            parent ,
            false
        )
        return PdSportsHeadingOuterViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PdSportsHeadingOuterRVAdapter.PdSportsHeadingOuterViewHolder ,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
}

class PdSportsHeadingOuterDiffUtilCallBack : DiffUtil.ItemCallback<PDSportsNameListData>() {
    override fun areItemsTheSame(
        oldItem: PDSportsNameListData ,
        newItem: PDSportsNameListData
    ): Boolean {
        return oldItem.sportName == newItem.sportName
    }

    override fun areContentsTheSame(
        oldItem: PDSportsNameListData ,
        newItem: PDSportsNameListData
    ): Boolean {
        return oldItem == newItem

    }


}