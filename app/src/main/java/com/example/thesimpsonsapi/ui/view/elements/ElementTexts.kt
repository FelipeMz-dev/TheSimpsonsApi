package com.example.thesimpsonsapi.ui.view.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thesimpsonsapi.data.Character

@Composable
fun ElementTexts(characterElement: Character) {
    var isExpanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
        Text(
            characterElement.name,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            characterElement.history,
            color = MaterialTheme.colorScheme.onPrimary,
            maxLines = if (isExpanded) Int.MAX_VALUE else 2
        )
    }
}