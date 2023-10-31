package com.example.thesimpsonsapi.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.example.thesimpsonsapi.data.Character
import com.example.thesimpsonsapi.ui.view.elements.ElementComponent
import com.example.thesimpsonsapi.ui.view.elements.ElementImageOpen
import com.example.thesimpsonsapi.ui.view.modifier.simpleVerticalScrollBar
import com.example.thesimpsonsapi.ui.viewmodel.MainViewModel

@Composable
fun Main(viewModel: MainViewModel) {
    val state by viewModel.uiState.collectAsState()
    val scrollState = rememberLazyListState()
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .simpleVerticalScrollBar(scrollState)
                .background(color = MaterialTheme.colorScheme.background)
                .alpha(if (state.isOpenImage) 0.5f else 1f)
                .padding(horizontal = 6.dp),
            state = scrollState
        ) {
            items(state.items) { character ->
                ElementComponent(character, viewModel)
            }
        }
    }

    if (state.isOpenImage) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { state.isOpenImage = false },
            contentAlignment = Alignment.Center
        ) {
            ElementImageOpen(url = state.urlImage)
        }
    }

}