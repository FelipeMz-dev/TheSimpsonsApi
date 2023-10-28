package com.example.thesimpsonsapi.data

import androidx.lifecycle.LiveData
import com.example.thesimpsonsapi.data.remote.ApiClient
import com.example.thesimpsonsapi.data.remote.ApiService

class DataRepository(private val apiClient: ApiClient) {
    suspend fun getCharacters(limit: Int): List<Character> {
        return apiClient.getCharacters(limit)
    }
}