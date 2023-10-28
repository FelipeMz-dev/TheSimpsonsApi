package com.example.thesimpsonsapi.data.remote

import com.example.thesimpsonsapi.data.Character
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val baseUrl = "https://apisimpsons.fly.dev/api/"

    suspend fun getCharacters(limit: Int): List<Character> {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
            .getCharacters(limit)
            .docs
            .map { it.toCharacter() }
    }

    private val retrofit: Retrofit? = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getService() = retrofit?.create(ApiService::class.java)
}