package com.example.thesimpsonsapi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thesimpsonsapi.ui.view.Main
import com.example.thesimpsonsapi.ui.view.SplashScreen
import com.example.thesimpsonsapi.ui.viewmodel.MainViewModel

@Composable
fun AppNavigation(viewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route) {
        composable(route = AppScreens.SplashScreen.route){
            SplashScreen(navController, viewModel)
        }
        composable(route = AppScreens.MainScreen.route){
            Main(viewModel)
        }
    }

}