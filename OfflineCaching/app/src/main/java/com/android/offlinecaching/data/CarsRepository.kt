package com.android.offlinecaching.data

import androidx.lifecycle.LiveData
import com.android.offlinecaching.network.CarsApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CarsRepository(
    private val database: CarsDatabase,
    private val apiService: CarsApiService
) {

    fun getCars(): LiveData<List<Cars>> {
        return database.carsDao.getAllCars()
    }

    suspend fun refreshCars(token: String?) {
        withContext(Dispatchers.IO) {
            try {
                val carsList = apiService.getCars() // ✅ Directly returns List<Cars>

                val safeCars = carsList.filter {
                    !it.car.isNullOrEmpty() &&
                            !it.carModel.isNullOrEmpty() &&
                            !it.carVin.isNullOrEmpty()
                }

                if (safeCars.isNotEmpty()) {
                    database.carsDao.insertCarsToRoom(safeCars)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
