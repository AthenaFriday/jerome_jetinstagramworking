package com.android.offlinecaching.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.android.offlinecaching.data.Cars

@Composable
fun CarsScreen(
    cars: List<Cars>,
    isLoading: Boolean,
    errorMessage: String?,
    onCarClick: (Cars) -> Unit
) {
    when {
        isLoading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        errorMessage != null -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = errorMessage,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
        cars.isEmpty() -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("No cars available.", style = MaterialTheme.typography.bodyLarge)
            }
        }
        else -> {
            LazyColumn {
                items(cars) { car ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable { onCarClick(car) }
                    ) {
                        val placeholderUrl = "https://via.placeholder.com/300.png?text=${car.car}"
                        Image(
                            painter = rememberAsyncImagePainter(placeholderUrl),
                            contentDescription = "Car Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .padding(bottom = 8.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text("Car: ${car.car}", style = MaterialTheme.typography.titleLarge)
                        Text("Model: ${car.carModel}", style = MaterialTheme.typography.bodyMedium)
                        Text("Color: ${car.carColor}", style = MaterialTheme.typography.bodyMedium)
                        Text("Year: ${car.carModelYear}", style = MaterialTheme.typography.bodySmall)
                        Text("VIN: ${car.carVin}", style = MaterialTheme.typography.bodySmall)
                        Text("Price: ${car.price}", style = MaterialTheme.typography.bodySmall)
                        Text(
                            "Available: ${if (car.availability == true) "Yes" else "No"}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}
