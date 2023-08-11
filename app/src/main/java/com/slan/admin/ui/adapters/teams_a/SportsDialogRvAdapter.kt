package com.slan.admin.ui.adapters.teams_a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.SportsDialogListData
import com.slan.admin.databinding.RvDialogboxSportsBinding

class SportsDialogRvAdapter(val cal: CustomCallBackInterface) :
    ListAdapter<SportsDialogListData , SportsDialogRvAdapter.SportsDialogViewHolder>(
        SportsDialogDiffCallBack()
    ) {

    private var selectedId: Int? = null
    private var lastSelectedIndex: Int? = null

    inner class SportsDialogViewHolder(private val binding: RvDialogboxSportsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        //        fun bind(item: SportsDialogListData , selectedId: Int?)
        fun bind(item: SportsDialogListData , position: Int) {


            val id = item.id
            binding.rb.text = item.sportsName

//            binding.root.setOnClickListener {
//                cal.returnedItemFromAdapter(id)
//                lastSelectedIndex = position
////                notifyDataSetChanged()
//
//            }

//            itemView.setOnClickListener {
//                cal.returnedItemFromAdapter(item.id)
//                lastSelectedIndex = position
//                notifyDataSetChanged()
//            }

            //  Set the radio button checked state based on selected item
//            binding.rb.isChecked = id == selectedId
//            binding.rb.isChecked =position == lastSelectedIndex


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): SportsDialogViewHolder {
        val binding =
            RvDialogboxSportsBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return SportsDialogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SportsDialogViewHolder , position: Int) {
        holder.bind(getItem(position),position)
//        holder.bind(getItem(position),selectedId)

    }


    fun setSelectedItem(selectedId: Int?) {
        this.selectedId = selectedId

    }
    fun getSelectedId(): Int? {
        return selectedId

    }
}

class SportsDialogDiffCallBack : DiffUtil.ItemCallback<SportsDialogListData>() {
    override fun areItemsTheSame(
        oldItem: SportsDialogListData ,
        newItem: SportsDialogListData
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: SportsDialogListData ,
        newItem: SportsDialogListData
    ): Boolean {
        return oldItem == newItem
    }
}


interface CustomCallBackInterface {
    fun returnedItemFromAdapter(selectedItemIndex: Int)

}
