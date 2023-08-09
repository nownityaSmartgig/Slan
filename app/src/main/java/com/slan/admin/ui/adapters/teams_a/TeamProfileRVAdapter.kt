package com.slan.admin.ui.adapters.teams_a

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.TeamProfileListData
import com.slan.admin.databinding.FragmentTeamProfileBinding
import com.slan.admin.databinding.RvLayoutPastMatchesBinding

class TeamProfileRVAdapter:ListAdapter<TeamProfileListData, TeamProfileRVAdapter.TeamProfileViewHolder>(TeamProfileDiffCallBack()) {
    class TeamProfileViewHolder(private val binding: RvLayoutPastMatchesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: TeamProfileListData) {

            binding.apply {
                //  TeamName
                tvTeamOneName.text = item.teamsName[0].teamOne
                tvTeamTwoName.text = item.teamsName[0].teamTwo

                //  Game Number And Group
                val gameNum = item.gameNumber
                val group = item.group
                tvGameNumAndGroup.text = "$gameNum Game, Group $group"
                tvGameLocation.text = item.location

                //  Date and time
                val time = item.time
                val date = item.date
                tvGameDateAndTime.text = "$date-$time/Local"

                //  Score Table
                val scoreTable = layoutMatchScoreTable
                scoreTable.tvTeamOneNameHeading.text =item.teamsName[0].teamOne
                scoreTable.tvTeamTwoNameHeading.text = item.teamsName[0].teamTwo

                scoreTable.tvTeamOneScoreROne.text =item.teamOneScore[0].roundOne
                scoreTable.tvTeamOneScoreRTwo.text =item.teamOneScore[0].roundTwo
                scoreTable.tvTeamOneScoreRThree.text =item.teamOneScore[0].roundThree
                scoreTable.tvTeamOneScoreRFour.text =item.teamOneScore[0].roundFour
                scoreTable.tvTeamOneScoreRFive.text =item.teamOneScore[0].roundFive

                scoreTable.tvTeamTwoScoreROne.text =item.teamTwoScore[0].roundOne
                scoreTable.tvTeamTwoScoreRTwo.text =item.teamTwoScore[0].roundTwo
                scoreTable.tvTeamTwoScoreRThree.text =item.teamTwoScore[0].roundThree
                scoreTable.tvTeamTwoScoreRFour.text =item.teamTwoScore[0].roundFour
                scoreTable.tvTeamTwoScoreRFive.text = item.teamTwoScore[0].roundFive


                val finalScoreOne = (item.teamOneScore[0].roundOne.toInt() + item.teamOneScore[0].roundTwo.toInt() + item.teamOneScore[0].roundThree.toInt() + item.teamOneScore[0].roundFour.toInt() + item.teamOneScore[0].roundFive.toInt()).toString()
                val finalScoreTwo = (item.teamTwoScore[0].roundOne.toInt() + item.teamTwoScore[0].roundTwo.toInt() + item.teamTwoScore[0].roundThree.toInt() + item.teamTwoScore[0].roundFour.toInt() + item.teamTwoScore[0].roundFive.toInt()).toString()

//                Toast.makeText(itemView.context , "$finalScoreOne $finalScoreTwo"  , Toast.LENGTH_SHORT).show()

                if (finalScoreOne > finalScoreTwo) {
                    ivTeamOneTick.visibility = View.VISIBLE
                    scoreTable.ivTableTeamOneCheck.visibility = View.VISIBLE

                    ivTeamTwoTick.visibility = View.GONE
                    scoreTable.ivTableTeamTwoCheck.visibility = View.GONE

                } else {
                    ivTeamOneTick.visibility = View.GONE
                    scoreTable.ivTableTeamOneCheck.visibility = View.GONE

                    ivTeamTwoTick.visibility = View.VISIBLE
                    scoreTable.ivTableTeamTwoCheck.visibility = View.VISIBLE
                }

            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): TeamProfileViewHolder {
        val binding =
            RvLayoutPastMatchesBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return TeamProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamProfileViewHolder , position: Int) {
        holder.bind(getItem(position))
    }
}

class TeamProfileDiffCallBack : DiffUtil.ItemCallback<TeamProfileListData>() {
    override fun areItemsTheSame(
        oldItem: TeamProfileListData ,
        newItem: TeamProfileListData
    ): Boolean {
        return oldItem.teamsName == newItem.teamsName
    }

    override fun areContentsTheSame(
        oldItem: TeamProfileListData ,
        newItem: TeamProfileListData
    ): Boolean {
        return oldItem== newItem
    }


}
