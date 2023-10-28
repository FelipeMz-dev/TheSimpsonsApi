package com.example.thesimpsonsapi.ui.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesimpsonsapi.data.remote.ApiClient
import com.example.thesimpsonsapi.data.Character
import com.example.thesimpsonsapi.data.DataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

class MainViewModel(private val repository: DataRepository) : ViewModel() {
    val items: MutableStateFlow<List<Character>> = MutableStateFlow(listOf())
    var isOpenImage: Boolean by mutableStateOf(false)
    var urlImage: String by mutableStateOf("")

    init {
        viewModelScope.launch {
            items.value = repository.getCharacters(650)
        }
    }

}