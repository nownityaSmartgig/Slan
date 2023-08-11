package com.slan.admin.ui.adapters.tournments_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.ParticipantListData
import com.slan.admin.databinding.RvLayoutParticipantListBinding
import com.slan.admin.ui.fragment.tournaments.ViewParticipantsFragmentDirections


class MyParticipantListRVAdapter:ListAdapter<ParticipantListData,MyParticipantListRVAdapter.MyParticipantViewHolder> (MyParticipantDiffUtillCallBack()){
    class MyParticipantViewHolder(private val binding:RvLayoutParticipantListBinding):RecyclerView.ViewHolder(binding.root) {


        init {
            binding.tvParticipantNameDetails.setOnClickListener {
                val action=ViewParticipantsFragmentDirections.actionViewParticipantsFragmentToViewParticipantsDetailsFragment()
                it.findNavController().navigate(action)
            }
            binding.tvRegistrantDetails.setOnClickListener {
                val action=ViewParticipantsFragmentDirections.actionViewParticipantsFragmentToViewRegistrantDetails()
                it.findNavController().navigate(action)
            }
        }
        fun bind(item: ParticipantListData){
            binding.tvParticipantNameDetails.text=item.ParticipantName
            binding.tvEventNameDetails.text=item.EventName
            binding.tvDateDetails.text=item.Date
            binding.tvRegistrantDetails.text=item.RegistrantDetails

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyParticipantViewHolder {
        val binding=RvLayoutParticipantListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyParticipantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyParticipantViewHolder, position: Int) {
        holder.bind(getItem(position))

    }
}

class MyParticipantDiffUtillCallBack :DiffUtil.ItemCallback<ParticipantListData>(){
    override fun areItemsTheSame(
        oldItem: ParticipantListData,
        newItem: ParticipantListData
    ): Boolean {
        return oldItem.ParticipantName==newItem.ParticipantName
    }

    override fun areContentsTheSame(
        oldItem: ParticipantListData,
        newItem: ParticipantListData
    ): Boolean {
        return oldItem==newItem
    }


}
