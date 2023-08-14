package com.slan.admin.data.source.local

import com.slan.admin.data.model.DMyEventsListData

class DMyEventsDataSource {
    fun loadDMyEventsDataSource():List<DMyEventsListData>{
        return listOf(
            DMyEventsListData(
                "Squash","Subbu Sp",""
                ),
            DMyEventsListData(
                "Squash","Subbu Sp",""
            ),
            DMyEventsListData(
                "Squash","Subbu Sp",""
            )

        )
    }
}