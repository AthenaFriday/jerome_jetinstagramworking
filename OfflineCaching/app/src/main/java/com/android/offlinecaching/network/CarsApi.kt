package com.android.offlinecaching.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CarsApi {
    private const val BASE_URL = "https://myfakeapi.com/api/cars/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService: CarsApiService by lazy {
        retrofit.create(CarsApiService::class.java)
    }
}
