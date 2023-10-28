package com.example.thesimpsonsapi.ui.view.elements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.thesimpsonsapi.data.Character
import com.example.thesimpsonsapi.ui.viewmodel.MainViewModel

@Composable
fun ElementComponent(characterElement: Character, viewModel: MainViewModel) {
    Row(
        modifier = Modifier.padding(8.dp)
    ) {
        ElementImage(characterElement.urlImage, viewModel)
        Spacer(modifier = Modifier.width(8.dp))
        ElementTexts(characterElement)
    }
}