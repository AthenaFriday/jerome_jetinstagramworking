package com.android.tenderapp.data

data class TenderResponse(
    val page_count: Int,
    val page_number: Int,
    val page_size: Int,
    val total: Int,
    val data: List<Tender>
)