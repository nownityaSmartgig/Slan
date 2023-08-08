package com.slan.admin.ui.adapters.players_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.PlayerPaymentData
import com.slan.admin.databinding.RvLayoutPlayerPaymentRecordBinding

class PlayerPaymentsRVAdapter : ListAdapter<PlayerPaymentData, PlayerPaymentsRVAdapter.PlayerPaymentsViewHolder>(PlayerPaymentsDiffCallBack()) {
    class PlayerPaymentsViewHolder(private val binding: RvLayoutPlayerPaymentRecordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PlayerPaymentData) {
            binding.tvOrderNo.text = item.orderNumber
            binding.tvDate.text = item.date
            binding.tvRegFor.text = item.regFor
            binding.tvAmtPaid.text = item.amtPaid
            binding.tvOrderStatus.text = item.orderStatus
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): PlayerPaymentsViewHolder {
        val binding = RvLayoutPlayerPaymentRecordBinding.inflate(
            LayoutInflater.from(parent.context) ,
            parent ,
            false
        )
        return PlayerPaymentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerPaymentsViewHolder , position: Int) {
        holder.bind(getItem(position))
    }

}

class PlayerPaymentsDiffCallBack : DiffUtil.ItemCallback<PlayerPaymentData>() {
    override fun areItemsTheSame(oldItem: PlayerPaymentData , newItem: PlayerPaymentData): Boolean {
        return oldItem.orderNumber == newItem.orderNumber
    }

    override fun areContentsTheSame(
        oldItem: PlayerPaymentData ,
        newItem: PlayerPaymentData
    ): Boolean {
        return oldItem == newItem

    }


}
