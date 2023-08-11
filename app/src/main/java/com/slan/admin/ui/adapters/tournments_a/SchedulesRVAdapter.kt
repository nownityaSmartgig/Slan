package com.slan.admin.ui.adapters.tournments_a

import android.annotation.SuppressLint
import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slan.admin.data.model.TSchedulesListData
import com.slan.admin.databinding.DialogBoxAddScoreBinding
import com.slan.admin.databinding.RvLayoutTeamVsTeamScoreBinding

class SchedulesRVAdapter:ListAdapter<TSchedulesListData,SchedulesRVAdapter.SchedulesViewHolder>(SchedulesDiffUtilCallBack()) {
    class SchedulesViewHolder(private val binding: RvLayoutTeamVsTeamScoreBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: TSchedulesListData) {

            binding.apply {
                tvLeagueNameHeading.text = item.leagueName
                tvTeamOneName.text = item.teamsName[0].teamOne
                tvTeamTwoName.text = item.teamsName[0].teamTwo

                //  Game Number And Group
                val gameNum = item.matchNumber
                val group = item.group
                tvTournamentTimeDate.text = "$gameNum Game, Group $group"
                //  Date and time
                val time = item.time
                val date = item.date
                tvTournamentLocation.text ="$date-$time/Local"

                if (!(item.teamOneScore[0].roundOne).isNullOrEmpty() && !(item.teamTwoScore[0].roundOne).isNullOrEmpty()) {

                    binding.clScoreLayout.visibility = View.VISIBLE
                    binding.btnAddScore.visibility = View.GONE
                    //  Score Table
                    val scoreTable = layoutScoreTable
                    scoreTable.tvTeamOneNameHeading.text = item.teamsName[0].teamOne
                    scoreTable.tvTeamTwoNameHeading.text = item.teamsName[0].teamTwo

                    scoreTable.tvTeamOneScoreROne.text = item.teamOneScore[0].roundOne
                    scoreTable.tvTeamOneScoreRTwo.text = item.teamOneScore[0].roundTwo
                    scoreTable.tvTeamOneScoreRThree.text = item.teamOneScore[0].roundThree
                    scoreTable.tvTeamOneScoreRFour.text = item.teamOneScore[0].roundFour
                    scoreTable.tvTeamOneScoreRFive.text = item.teamOneScore[0].roundFive

                    scoreTable.tvTeamTwoScoreROne.text = item.teamTwoScore[0].roundOne
                    scoreTable.tvTeamTwoScoreRTwo.text = item.teamTwoScore[0].roundTwo
                    scoreTable.tvTeamTwoScoreRThree.text = item.teamTwoScore[0].roundThree
                    scoreTable.tvTeamTwoScoreRFour.text = item.teamTwoScore[0].roundFour
                    scoreTable.tvTeamTwoScoreRFive.text = item.teamTwoScore[0].roundFive


                    val finalScoreOne =
                        (item.teamOneScore[0].roundOne.toInt() + item.teamOneScore[0].roundTwo.toInt() + item.teamOneScore[0].roundThree.toInt() + item.teamOneScore[0].roundFour.toInt() + item.teamOneScore[0].roundFive.toInt()).toString()
                    val finalScoreTwo =
                        (item.teamTwoScore[0].roundOne.toInt() + item.teamTwoScore[0].roundTwo.toInt() + item.teamTwoScore[0].roundThree.toInt() + item.teamTwoScore[0].roundFour.toInt() + item.teamTwoScore[0].roundFive.toInt()).toString()

//                Toast.makeText(itemView.context , "$finalScoreOne $finalScoreTwo"  , Toast.LENGTH_SHORT).show()

                    if (finalScoreOne > finalScoreTwo) {
                        ivWinCheckA.visibility = View.VISIBLE
                        scoreTable.ivTeamOneCheck.visibility = View.VISIBLE

                        ivWinCheckB.visibility = View.GONE
                        scoreTable.ivTeamTwoCheck.visibility = View.GONE

                    } else {
                        ivWinCheckA.visibility = View.GONE
                        scoreTable.ivTeamOneCheck.visibility = View.GONE

                        ivWinCheckB.visibility = View.VISIBLE
                        scoreTable.ivTeamTwoCheck.visibility = View.VISIBLE
                    }
                } else {

                    binding.apply {
                        clScoreLayout.visibility = View.GONE
                        btnAddScore.visibility = View.VISIBLE

                        btnAddScore.setOnClickListener {
                            dialogBox()
                        }
                    }



                }




            }




        }

        private fun dialogBox() {
            val dialogBoxBinding =
                DialogBoxAddScoreBinding.inflate(LayoutInflater.from(binding.root.context))
            val dialogBox = Dialog(dialogBoxBinding.root.context)
            dialogBox.setContentView(dialogBoxBinding.root)


            dialogBoxBinding.ivClose.setOnClickListener {
                dialogBox.dismiss()
            }

            dialogBoxBinding.btSave.setOnClickListener {
                dialogBox.dismiss()
            }

            dialogBox.show()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): SchedulesViewHolder {
        val binding = RvLayoutTeamVsTeamScoreBinding.inflate(
            LayoutInflater.from(parent.context) ,
            parent ,
            false
        )
        return SchedulesViewHolder(binding)

    }

    override fun onBindViewHolder(holder: SchedulesViewHolder , position: Int) {
        holder.bind(getItem(position))
    }
}

class SchedulesDiffUtilCallBack:DiffUtil.ItemCallback<TSchedulesListData>() {
    override fun areItemsTheSame(
        oldItem: TSchedulesListData ,
        newItem: TSchedulesListData
    ): Boolean {
        return oldItem.leagueName == newItem.leagueName
    }

    override fun areContentsTheSame(
        oldItem: TSchedulesListData ,
        newItem: TSchedulesListData
    ): Boolean {
        return oldItem == newItem
    }

}
