package com.slan.admin.data.source.local

import com.slan.admin.data.model.PDMyTeamsListData

class PDMyTeamsDataSource {
    fun loadPDMyTeamsDataSource():List<PDMyTeamsListData> {
        return listOf(
            PDMyTeamsListData("Subbu Spartans","Cricket") ,
            PDMyTeamsListData("Subbu Spartans","Badminton") ,

            )
    }
}