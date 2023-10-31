package com.example.thesimpsonsapi.data.remote

import com.example.thesimpsonsapi.data.remote.character.ServerResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("personajes")
    suspend fun getCharacters(@Query("limit") limit: Int): ServerResult
}