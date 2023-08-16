package com.example.thesimpsonsapi.data

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("personajes")
    suspend fun getCharacters(@Query("limit") limit: Int): Response<ResponseBody>
}