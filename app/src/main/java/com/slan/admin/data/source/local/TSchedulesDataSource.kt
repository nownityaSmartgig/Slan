package com.slan.admin.data.source.local

import com.slan.admin.data.model.TSchedulesListData
import com.slan.admin.data.model.TeamName
import com.slan.admin.data.model.TeamOneScore
import com.slan.admin.data.model.TeamOneScores
import com.slan.admin.data.model.TeamProfileListData
import com.slan.admin.data.model.TeamTwoScore
import com.slan.admin.data.model.TeamTwoScores
import com.slan.admin.data.model.TeamsName

class TSchedulesDataSource {
    fun loadTSchedulesDataSource(): List<TSchedulesListData> {
        return listOf(
            TSchedulesListData(
                "SLAN Racket Sport Tournament" ,
                listOf(TeamsName("ABC" , "XYZ")) ,
                "12" ,
                "D" ,
                "B-SPORTS Madhapur" ,
                "Wed, 27 Jun 2023" ,
                "06:00 AM/Local" ,
                listOf(TeamOneScores("5" , "2" , "7" , "4" , "4")) ,
                listOf(TeamTwoScores("9" , "8" , "9" , "8" , "9"))

            ),

            TSchedulesListData(
                "SLAN CRIC U-40 League" ,
                listOf(TeamsName("ABC" , "XYZ")) ,
                "12" ,
                "D" ,
                "B-SPORTS Madhapur" ,
                "Wed, 27 Jun 2023" ,
                "06:00 AM/Local" ,
                listOf(TeamOneScores("" , "" , "" , "" , "")) ,
                listOf(TeamTwoScores("" , "" , "" , "" , ""))

            ),
        )
    }
}