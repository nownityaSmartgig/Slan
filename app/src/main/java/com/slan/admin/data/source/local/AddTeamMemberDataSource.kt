package com.slan.admin.data.source.local

import com.slan.admin.data.model.AddTeamMemberListData

class AddTeamMemberDataSource {
    fun loadAddTeamMemberDataSource(): List<AddTeamMemberListData> {
        return listOf(
            AddTeamMemberListData("Goutham","8709960358"),
            AddTeamMemberListData("Krishna","8709960358")
        )
    }
}