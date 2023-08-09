package com.slan.admin.data.model

data class TeamProfileListData(
    val teamsName: List<TeamName> ,
    val group: String ,
    val gameNumber: String ,
    val location: String ,
    val time: String ,
    val date: String,
    val teamOneScore:List<TeamOneScore>,
    val teamTwoScore:List<TeamTwoScore>
)

data class TeamName(
    val teamOne:String,
    val teamTwo:String,
)

data class TeamOneScore(
    val roundOne:String,
    val roundTwo:String,
    val roundThree:String,
    val roundFour:String,
    val roundFive:String,

)data class TeamTwoScore(
    val roundOne:String,
    val roundTwo:String,
    val roundThree:String,
    val roundFour:String,
    val roundFive:String,

    )
