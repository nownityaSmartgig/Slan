package com.slan.admin.data.source.local

import com.slan.admin.data.model.AllPlayerListData

class AllPlayerDataSource {
    fun loadAllPlayersDataSource(): List<AllPlayerListData> {
        return listOf(
            AllPlayerListData("Subbu Sp" , "7894561233", "") ,
            AllPlayerListData("Subbu Sp" , "8945612370", "") ,
            AllPlayerListData("Goutham" , "9456123780", "") ,
            AllPlayerListData("Krishna" , "6345127890", "") ,
            AllPlayerListData("Alexa" , "7894561222", "") ,
            AllPlayerListData("Siri" , "8945612377", "") ,
        )

    }
}