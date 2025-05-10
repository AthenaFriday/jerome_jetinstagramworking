package com.android.offlinecaching.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cars::class], version = 2, exportSchema = false)
abstract class CarsDatabase : RoomDatabase() {
    abstract val carsDao: CarsDao
}

private lateinit var INSTANCE: CarsDatabase

fun getDatabase(context: Context): CarsDatabase {
    synchronized(CarsDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {

            // 💣 TEMP FIX: Force delete old DB to resolve schema hash mismatch
            context.deleteDatabase("cars_database")

            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                CarsDatabase::class.java,
                "cars_database"
            )
                .fallbackToDestructiveMigration() // Wipes and rebuilds the DB on schema change
                .build()
        }
        return INSTANCE
    }
}
