package com.slan.admin.ui.adapters.players_a

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.AllPlayerListData
import com.slan.admin.databinding.RvLayoutAllPlayersBinding
import com.slan.admin.ui.fragment.players.AllPlayersFragment
import com.slan.admin.ui.fragment.players.AllPlayersFragmentDirections

class AllPlayersRVAdapter :
    ListAdapter<AllPlayerListData , AllPlayersRVAdapter.AllPlayerViewHolder>(AllPlayerDiffCallBack()) {
    class AllPlayerViewHolder(private val binding: RvLayoutAllPlayersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {

            binding.tvPlayerName.setOnClickListener {
                val pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    val player = itemId
//                    Toast.makeText(itemView.context , "$player" , Toast.LENGTH_SHORT).show()
                    val action =
                        AllPlayersFragmentDirections.actionNavigationPlayersToPlayerDetailsFragment()

                    it.findNavController().navigate(action)


                }
            }

            binding.tvViewDetails.setOnClickListener {
                val pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    val player = itemId
                    val player2 = layoutPosition
//                    Toast.makeText(itemView.context , "$player, $player2" , Toast.LENGTH_SHORT).show()

                    val action =
                        AllPlayersFragmentDirections.actionNavigationPlayersToPlayerPaymentsFragment()
                    it.findNavController().navigate(action)



                }
            }

        }

        fun bind(item: AllPlayerListData) {
            binding.tvPlayerName.text = item.playerName
            binding.tvPhoneNumber.text = item.playerNumber

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): AllPlayerViewHolder {
        val binding =
            RvLayoutAllPlayersBinding
                .inflate(
                    LayoutInflater.from(parent.context) , parent , false
                )
        return AllPlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AllPlayerViewHolder , position: Int) {
        holder.bind(getItem(position))

    }
}

class AllPlayerDiffCallBack : DiffUtil.ItemCallback<AllPlayerListData>() {
    override fun areItemsTheSame(oldItem: AllPlayerListData , newItem: AllPlayerListData): Boolean {
        return oldItem.playerName == newItem.playerName
    }

    override fun areContentsTheSame(
        oldItem: AllPlayerListData ,
        newItem: AllPlayerListData
    ): Boolean {
        return oldItem == newItem
    }
}