package com.android.offlinecaching.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CarsDao {

    // Fetch all cars from the local database
    @Query("SELECT * FROM cars_table")
    fun getAllCars(): LiveData<List<Cars>>

    // Insert or replace list of cars (used during refresh)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCarsToRoom(cars: List<Cars>)
}
