package com.slan.admin.data.source.local

import com.slan.admin.data.model.MatchesListData
import com.slan.admin.data.model.Players

class MatchesDataSource {
    fun loadMatchesDataSource(): List<MatchesListData> {
        return listOf(
            MatchesListData(
                listOf(
                    Players("Bob", "John")
                )
            ),
            MatchesListData(
                listOf(
                    Players("Bob", "John")
                )
            ),
            MatchesListData(
                listOf(
                    Players("Bob", "John")
                )
            ),
            MatchesListData(
                listOf(
                    Players("Bob", "John")
                )
            ),
            MatchesListData(
                listOf(
                    Players("Bob", "John")
                )
            ),
            MatchesListData(
                listOf(
                    Players("Bob", "John")
                )
            ),
            MatchesListData(
                listOf(
                    Players("Bob", "John")
                )
            )


        )
    }

}
