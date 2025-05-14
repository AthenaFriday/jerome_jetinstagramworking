package com.android.tenderapp.repository

import com.android.tenderapp.data.Tender
import com.android.tenderapp.remote.TenderApi
import javax.inject.Inject

class TenderRepository @Inject constructor(
    private val api: TenderApi
) {
    suspend fun fetchTenders(): List<Tender> {
        return api.getTenders().data
    }
}
