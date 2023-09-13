package com.example.papewall.repository


import com.example.papewall.model.networking.API
import com.example.papewall.model.networking.RetroService

class MainRepository {
    fun retroService(): RetroService = API.apiService
}