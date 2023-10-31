package com.example.thesimpsonsapi.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.thesimpsonsapi.R
import com.example.thesimpsonsapi.ui.navigation.AppScreens
import com.example.thesimpsonsapi.ui.viewmodel.MainViewModel

@Composable
fun SplashScreen(navController: NavHostController, viewModel: MainViewModel) {
    Splash()
    LaunchedEffect(key1 = true){
        viewModel.getItems()
    }
    if (!viewModel.isLoading) {
        LaunchedEffect(key1 = true) {
            navController.popBackStack()
            navController.navigate(AppScreens.MainScreen.route)
        }

    }
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.icon_thesimpsonsapi_removebg_preview),
            contentDescription = "Splash Screen",
            Modifier.size(200.dp))
        Text(
            text = "The Simpsons",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,)
    }
}