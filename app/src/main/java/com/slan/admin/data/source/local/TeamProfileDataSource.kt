package com.slan.admin.data.source.local

import com.slan.admin.data.model.TeamName
import com.slan.admin.data.model.TeamOneScore
import com.slan.admin.data.model.TeamProfileListData
import com.slan.admin.data.model.TeamTwoScore

class TeamProfileDataSource() {
    fun loadTeamProfileDataSource(): List<TeamProfileListData> {
        return listOf(
            TeamProfileListData(
                listOf(TeamName("Sunrisers" , "Star walkers")) ,
                "A" ,
                "12" ,
                "Gamepoint Madhapur" ,
                "Wed, 14 Jun 2023" ,
                "06:00 AM" ,
                listOf(TeamOneScore("5" , "2" , "7" , "4" , "4")) ,
                listOf(TeamTwoScore("9" , "8" , "9" , "8" , "9"))
            ),
            TeamProfileListData(
                listOf(TeamName("qew79" , "379")) ,
                "A" ,
                "12" ,
                "Gamepoint Madhapur" ,
                "Wed, 14 Jun 2023" ,
                "06:00 AM" ,
                listOf(TeamOneScore("6" , "7" , "7" , "8" , "8")) ,
                listOf(TeamTwoScore("3" , "5" , "5" , "5" , "5"))
            )
        )
    }



}