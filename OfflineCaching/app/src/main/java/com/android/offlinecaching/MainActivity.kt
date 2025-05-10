package com.android.offlinecaching

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import com.android.offlinecaching.ui.CarsScreen
import com.android.offlinecaching.viewmodel.CarsViewModel
import com.android.offlinecaching.viewmodel.CarsViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val token: String? = null // Replace with real token if needed

        val viewModel: CarsViewModel = ViewModelProvider(
            this,
            CarsViewModelFactory(application, token)
        )[CarsViewModel::class.java]

        setContent {
            val cars by viewModel.carsList.observeAsState(initial = emptyList())
            val isLoading by viewModel.isLoading.observeAsState(initial = false)
            val errorMessage by viewModel.errorMessage.observeAsState(initial = null)

            CarsScreen(
                cars = cars,
                isLoading = isLoading,
                errorMessage = errorMessage,
                onCarClick = { selectedCar ->
                    Toast.makeText(
                        this,
                        "Clicked: ${selectedCar.car} (${selectedCar.carModel})",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
        }
    }
}
