package com.slan.admin.data.source.local

import com.slan.admin.R
import com.slan.admin.data.model.PDAllMatchesListData

class PDAllMatchesDataSource {
    fun loadPDAllMatchesDataSource(): List<PDAllMatchesListData> {
        return listOf(
            PDAllMatchesListData(R.drawable.ic_logo_event,"SLAN  E-Sport tournament","12 july","13 july","Gamepoint, Madhpur"),
            PDAllMatchesListData(R.drawable.ic_logo_event,"SLAN Racket Sport tournament","15 july","18 july","Gamepoint, Madhpur"),
            PDAllMatchesListData(R.drawable.ic_logo_event,"SLAN  E-Sport tournament","21 july","22 july","Gamepoint, Madhpur")
        )

    }


}