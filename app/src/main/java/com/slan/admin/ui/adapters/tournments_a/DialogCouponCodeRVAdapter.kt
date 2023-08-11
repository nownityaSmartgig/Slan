package com.slan.admin.ui.adapters.tournments_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.CouponCodeDialogListData

import com.slan.admin.databinding.RvLayoutCouponListBinding

class DialogCouponCodeRVAdapter:ListAdapter<CouponCodeDialogListData,DialogCouponCodeRVAdapter.DialogCouponViewHolder>(DialogCouponCodeDiffUtillCallBack()) {
    class DialogCouponViewHolder(private val binding: RvLayoutCouponListBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CouponCodeDialogListData) {
            val couponCode:String="Coupon Code\n${item.couponCode}"
            binding.tvCouponCode.text=couponCode
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DialogCouponViewHolder {
        val binding=RvLayoutCouponListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DialogCouponViewHolder(binding)

    }

    override fun onBindViewHolder(holder: DialogCouponViewHolder, position: Int) {
        holder.bind(getItem(position))

    }
}

class DialogCouponCodeDiffUtillCallBack: DiffUtil.ItemCallback<CouponCodeDialogListData>() {
    override fun areItemsTheSame(
        oldItem: CouponCodeDialogListData,
        newItem: CouponCodeDialogListData
    ): Boolean {
        return oldItem.couponCode==newItem.couponCode
    }

    override fun areContentsTheSame(
        oldItem: CouponCodeDialogListData,
        newItem: CouponCodeDialogListData
    ): Boolean {
        return oldItem==newItem
    }

}
