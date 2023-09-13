package com.example.papewall.model.domain

import com.khater.retromvvm.model.domain.Pagination


data class Wallpaper(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("paggination")
    val pagination: Pagination?,
    @SerializedName("success")
    val success: Boolean?
)