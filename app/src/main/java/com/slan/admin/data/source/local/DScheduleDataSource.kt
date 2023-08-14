package com.slan.admin.data.source.local

import com.slan.admin.data.model.DScheduleListData

class DScheduleDataSource {
    fun loadDScheduleDataSource():List<DScheduleListData>{
        return listOf(
            DScheduleListData(
                "SLAN Racket Sport League","ABC","XYZ","12","A","B-SPORTS Madhapur","Wed, 14 Jun 2023"," 06:00 AM"
            ),
            DScheduleListData(
                "SLAN Racket Sport League","ABC","XYZ","12","A","B-SPORTS Madhapur","Wed, 14 Jun 2023"," 06:00 AM"
            ),
            DScheduleListData(
                "SLAN Racket Sport League","ABC","XYZ","12","A","B-SPORTS Madhapur","Wed, 14 Jun 2023"," 06:00 AM"
            )
        )
    }
}