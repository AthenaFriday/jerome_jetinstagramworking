package com.android.offlinecaching.network

import com.android.offlinecaching.data.Cars
import retrofit2.http.GET

interface CarsApiService {
    @GET("cars/")
    suspend fun getCars(): List<Cars>
}
