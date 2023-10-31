package com.example.thesimpsonsapi.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesimpsonsapi.data.Character
import com.example.thesimpsonsapi.domain.GetCharactersUsesCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCharactersUsesCase: GetCharactersUsesCase
): ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: MutableStateFlow<MainUiState> = _uiState

    //val items: MutableStateFlow<List<Character>> = MutableStateFlow(listOf())
    ///var isOpenImage: Boolean by mutableStateOf(false)
    ///var urlImage: String by mutableStateOf("")
    //var isLoading: Boolean by mutableStateOf(true)

    fun getItems(){
        viewModelScope.launch {
            _uiState.value = MainUiState(isLoading = true)

            getCharactersUsesCase.invoke(650).let {
                _uiState.value = MainUiState(items = it)
            }
        }
    }

    data class MainUiState (
        val isLoading: Boolean = false,
        val items: List<Character> = emptyList(),
        var urlImage: String = "",
        var isOpenImage: Boolean = false
    )
}