package com.slan.admin.data.source.local

import com.slan.admin.data.model.PDMyPartnerListData

class PDMyPartnerDataSource {
    fun loadPDMyPartnerDataSource():List<PDMyPartnerListData> {
        return listOf(
            PDMyPartnerListData("Subbu Spartans","Cricket"),
            PDMyPartnerListData("Subbu Spartans","Badminton"),

        )
    }

}