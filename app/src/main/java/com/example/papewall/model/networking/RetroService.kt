package com.example.papewall.model.networking

import com.example.papewall.model.domain.Data
import com.example.papewall.model.domain.Wallpaper


interface RetroService {
    // https://woolapi.herokuapp.com/wallpapers/category?category=Gaming

    // https://woolapi.herokuapp.com/wallpapers/search?keyword=try

    @GET("Random")
    suspend fun getHomeFromApi(@Query("page") page: Int?):  Wallpaper


    @GET("popular")
    suspend fun getPopularFromApi(@Query("page") page: Int?):  Wallpaper

    @GET("latest")
    suspend fun getRandomFromApi(@Query("page") page: Int?):  Wallpaper

    @GET("category")
    suspend fun getCategoryFromApi(
        @Query("page") page: Int?,
        @Query("category") category: String
    ): Wallpaper


    @GET("search")
    suspend fun searchFromApi(
        @Query("page") page: Int?,
        @Query("keyword") keyword:  String
    ): Wallpaper

    @GET("category")
    suspend fun getCategoryToViewPager(
        @Query("category") category: String
    ):  Wallpaper

}


