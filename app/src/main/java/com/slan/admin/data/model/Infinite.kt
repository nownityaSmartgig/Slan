package com.slan.admin.data.model

data class Infinite(
    val infiniteScrollFlag: Boolean,
    val limit: Int,
    val offset: Int,
    val size: String
)