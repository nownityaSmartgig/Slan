package com.slan.admin.data.source.local

import com.slan.admin.data.model.DialogGeographyListData

class DialogGeographyDataSource {

    fun loadGeographyDataSource():List<DialogGeographyListData>{
        return listOf(
            DialogGeographyListData(
                "Afghanistan"
            ),
            DialogGeographyListData(
                "Albania"

            ),
            DialogGeographyListData(
                "Algeria"

            ),
            DialogGeographyListData(
                "Andorra"

            ),
            DialogGeographyListData(
                "Angola"

            ),
            DialogGeographyListData(
                "Antigua and Barbuda"
            ),
            DialogGeographyListData(
                "Argentina"
            ),
            DialogGeographyListData(
                "Armenia"

            ),
            DialogGeographyListData(
                "Australia"
            )
        )
    }
}