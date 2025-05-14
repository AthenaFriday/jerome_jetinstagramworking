package com.android.tenderapp.data


data class Tender(
    val id: String,
    val date: String,
    val title: String,
    val category: String,
    val description: String,
    val sid: String,
    val awarded_value: String,
    val awarded_currency: String,
    val awarded_value_eur: String,
    val purchaser: Purchaser,
    val type: TenderType,
    val awarded: List<Awarded>
)