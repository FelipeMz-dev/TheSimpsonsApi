package com.example.thesimpsonsapi.data.remote

import com.example.thesimpsonsapi.data.Character
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiClient @Inject constructor(private val apiService: ApiService) {

    suspend fun getCharacters(limit: Int): List<Character> = apiService
            .getCharacters(limit)
            .docs
            .map { it.toCharacter() }

}