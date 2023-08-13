package com.slan.admin.data.source.local

import com.slan.admin.data.model.PDSportsNameListData
import com.slan.admin.data.model.PDSportsStatusDataList

class PDSportsDataSource {
    fun loadPDSportsNameDataList(): List<PDSportsNameListData> {
        return listOf(
            PDSportsNameListData("Squash"),
            PDSportsNameListData("Badminton-Doubles"),
            PDSportsNameListData("Table Tennis-Singles"),

            )
    }

    fun loadPDSportsStatusDataList(): List<PDSportsStatusDataList> {
        return listOf(
            PDSportsStatusDataList("Subbu SP/******7930","299.00","0.00"),
            PDSportsStatusDataList("Subbu SP/******7930","299.00","0.00"),
            PDSportsStatusDataList("Subbu SP/******7930","299.00","0.00"),
            PDSportsStatusDataList("Subbu SP/******7930","299.00","0.00"),
            PDSportsStatusDataList("Subbu SP/******7930","299.00","0.00"),
            PDSportsStatusDataList("Subbu SP/******7930","299.00","0.00"),
            PDSportsStatusDataList("Subbu SP/******7930","299.00","0.00"),
            PDSportsStatusDataList("Subbu SP/******7930","299.00","0.00"),
            PDSportsStatusDataList("Subbu SP/******7930","299.00","0.00"),
        )
    }
}