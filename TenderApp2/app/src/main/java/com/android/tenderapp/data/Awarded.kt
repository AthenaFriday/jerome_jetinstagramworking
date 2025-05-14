package com.android.tenderapp.data

data class Awarded(
    val date: String,
    val value: String,
    val suppliers: List<Supplier>
)