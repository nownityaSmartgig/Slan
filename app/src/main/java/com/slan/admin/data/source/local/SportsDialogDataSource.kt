package com.slan.admin.data.source.local

import com.slan.admin.data.model.SportsDialogListData

class SportsDialogDataSource {

    fun loadSportsDialogDataSource(): List<SportsDialogListData> {
        return listOf(
            SportsDialogListData(1 , "All"),
            SportsDialogListData(2, "Football"),
            SportsDialogListData(3, "Basketball"),
            SportsDialogListData(5, "Tennis"),
            SportsDialogListData(6, "Cricket"),
            SportsDialogListData(14, "Volleyball"),

        )
    }

}