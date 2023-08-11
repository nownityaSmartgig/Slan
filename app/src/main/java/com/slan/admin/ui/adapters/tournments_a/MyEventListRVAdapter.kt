package com.slan.admin.ui.adapters.tournments_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.EventListData
import com.slan.admin.databinding.RvLayoutEventDetailsBinding
import com.slan.admin.ui.fragment.tournaments.TournamentsEventsFragmentDirections

class MyEventListRVAdapter:ListAdapter<EventListData,MyEventListRVAdapter.MyEventViewHolder>(MyEventDiffUtillCallBack()){
    class MyEventViewHolder(private val binding: RvLayoutEventDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.tvParticipantsCount.setOnClickListener {
                val action=TournamentsEventsFragmentDirections.actionTournamentsEventsToViewParticipantsFragment()
                it.findNavController().navigate(action)
            }

            binding.tvSportName.setOnClickListener {
                val action=TournamentsEventsFragmentDirections.actionTournamentsEventsToDrawScreenFragment()
                it.findNavController().navigate(action)
            }

            binding.btSchedule.setOnClickListener {
                val action =
                    TournamentsEventsFragmentDirections.actionTournamentsEventsToSchedulesFragment()
                it.findNavController().navigate(action
                )
            }
        }
        fun bind(item: EventListData) {
            binding.tvSportName.text = item.EventName
            binding.tvParticipantsCount.text = item.TotalParticipant
            binding.amountPaid.text = item.TotalAmtPaid
            binding.btSchedule
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyEventViewHolder {
        val binding=RvLayoutEventDetailsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyEventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyEventViewHolder, position: Int) {
        holder.bind(getItem(position))

    }


}

class MyEventDiffUtillCallBack:DiffUtil.ItemCallback<EventListData>() {
    override fun areItemsTheSame(oldItem: EventListData, newItem: EventListData): Boolean {
        return oldItem.EventName==newItem.EventName

    }

    override fun areContentsTheSame(oldItem: EventListData, newItem: EventListData): Boolean {
        return oldItem==newItem
    }

}
