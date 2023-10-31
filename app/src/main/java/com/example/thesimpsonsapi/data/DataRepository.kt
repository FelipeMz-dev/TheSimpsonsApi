package com.example.thesimpsonsapi.data

import com.example.thesimpsonsapi.data.remote.ApiClient
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiClient: ApiClient
) {
    suspend fun getCharacters(limit: Int): List<Character> = apiClient.getCharacters(limit)
}