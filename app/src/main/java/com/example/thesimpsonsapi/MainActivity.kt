package com.example.thesimpsonsapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.thesimpsonsapi.data.DataRepository
import com.example.thesimpsonsapi.data.remote.ApiClient
import com.example.thesimpsonsapi.ui.viewmodel.MainViewModel
import com.example.thesimpsonsapi.ui.theme.AnimalApiTheme
import com.example.thesimpsonsapi.ui.view.Main

private lateinit var viewModel: MainViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = DataRepository(ApiClient())
        viewModel = MainViewModel(repository)
        setContent {
            AnimalApiTheme {
                Main(viewModel)
            }
        }
    }
}
