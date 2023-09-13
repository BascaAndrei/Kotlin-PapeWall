package com.khater.retromvvm.model.domain


import com.example.papewall.model.domain.Next
import com.example.papewall.model.domain.SerializedName


data class Pagination(
    @SerializedName("next")
    val next: Next?,
    val prev: Next?
)