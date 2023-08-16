package com.slan.admin.data.model

data class Sample(
    val appContext: AppContext,
    val geolocation: Geolocation,
    val infinite: Infinite,
    val serialNumber: String,
    val type: String,
    val version: String
)