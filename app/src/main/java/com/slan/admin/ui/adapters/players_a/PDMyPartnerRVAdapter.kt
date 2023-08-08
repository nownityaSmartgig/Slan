package com.slan.admin.ui.adapters.players_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.R
import com.slan.admin.data.model.PDMyPartnerListData
import com.slan.admin.data.model.PDMyTeamsListData
import com.slan.admin.databinding.RvLayoutAllPlayersBinding
import com.slan.admin.databinding.RvLayoutPdMyTeamsBinding

class PDMyPartnerRVAdapter :
    ListAdapter<PDMyPartnerListData , PDMyPartnerRVAdapter.PDMyPartnerViewHolder>
        (PDMyPartnerDiffCallBack()) {
    class PDMyPartnerViewHolder(private val binding: RvLayoutPdMyTeamsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PDMyPartnerListData) {
            binding.tvTeamName.text = item.teamName

            binding.tvSports.text = item.sport

            when (item.sport) {
                "Cricket" -> binding.ivGameLogo.setImageResource(R.drawable.cricket_logo)
                "Badminton" -> binding.ivGameLogo.setImageResource(R.drawable.ic_shuttlecock_logo)
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): PDMyPartnerViewHolder {
        val binding = RvLayoutPdMyTeamsBinding.inflate(
            LayoutInflater.from(parent.context) ,
            parent , false
        )
        return PDMyPartnerViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PDMyPartnerViewHolder , position: Int) {
        holder.bind(getItem(position))
    }
}

class PDMyPartnerDiffCallBack:DiffUtil.ItemCallback<PDMyPartnerListData>() {
    override fun areItemsTheSame(
        oldItem: PDMyPartnerListData ,
        newItem: PDMyPartnerListData
    ): Boolean {
        return oldItem.teamName == newItem.teamName
    }

    override fun areContentsTheSame(
        oldItem: PDMyPartnerListData ,
        newItem: PDMyPartnerListData
    ): Boolean {
        return oldItem == newItem
    }


}
