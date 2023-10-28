package com.example.thesimpsonsapi.ui.view.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun ElementImageOpen(url: String) {
    val painter = rememberImagePainter(data = url)

    CircularProgressIndicator()

    Image(
        painter = painter,
        "image",
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .size(280.dp)
            .padding(10.dp)
            .clickable(true) {}
    )
}