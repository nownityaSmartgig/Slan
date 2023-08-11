package com.slan.admin.data.model

data class TSchedulesListData(
    val leagueName: String ,
    val teamsName: List<TeamsName> ,
    val matchNumber: String ,
    val group: String ,
    val location: String ,
    val date: String ,
    val time: String ,
    val teamOneScore: List<TeamOneScores> ,
    val teamTwoScore: List<TeamTwoScores>
)

data class TeamsName(
    val teamOne: String ,
    val teamTwo: String
)

data class TeamOneScores(
    val roundOne: String ,
    val roundTwo: String ,
    val roundThree: String ,
    val roundFour: String ,
    val roundFive: String
)

data class TeamTwoScores(
    val roundOne: String ,
    val roundTwo: String ,
    val roundThree: String ,
    val roundFour: String ,
    val roundFive: String ,

    )

