package com.example.thesimpsonsapi.ui.view.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.thesimpsonsapi.R
import com.example.thesimpsonsapi.ui.viewmodel.MainViewModel

@Composable
fun ElementImage(url: String, viewModel: MainViewModel) {
    val painter = rememberImagePainter(
        data = url,
        builder = {
            //placeholder(R.drawable.ic_launcher_foreground)
            error(R.drawable.baseline_visibility_off_24)
        }
    )
    Box(contentAlignment = Alignment.Center) {
        Image(
            painter = painter,
            "image character",
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.secondary)
                .size(72.dp)
                .clickable {
                    viewModel.isOpenImage = true
                    viewModel.urlImage = url
                }
        )
        if (painter.state is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(32.dp),
                color = Color.White
            )
        }
    }
}