package com.android.offlinecaching.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars_table")
data class Cars(
    @PrimaryKey val id: Int,

    @ColumnInfo(name = "car")
    val car: String,

    @ColumnInfo(name = "car_model")
    val carModel: String,

    @ColumnInfo(name = "car_color")
    val carColor: String,

    @ColumnInfo(name = "car_model_year")
    val carModelYear: Int,

    @ColumnInfo(name = "car_vin")
    val carVin: String,

    @ColumnInfo(name = "price")
    val price: String,

    @ColumnInfo(name = "availability")
    val availability: Boolean,

    @ColumnInfo(name = "image_url")
    val imageUrl: String? = null // Optional placeholder field
)

