package com.example.thesimpsonsapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thesimpsonsapi.ui.navigation.AppNavigation
import com.example.thesimpsonsapi.ui.theme.AnimalApiTheme
import com.example.thesimpsonsapi.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalApiTheme {
                AppNavigation(viewModel)
            }
        }
    }
}
