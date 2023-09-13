package com.example.papewall.model.domain




data class Next(
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("page")
    val page: Int
)