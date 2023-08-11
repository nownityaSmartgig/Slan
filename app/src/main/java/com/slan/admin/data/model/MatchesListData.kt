package com.slan.admin.data.model

data class MatchesListData(
    val players:List<Players>
)

data class Players(
    val player_1:String,
    val player_2:String
)