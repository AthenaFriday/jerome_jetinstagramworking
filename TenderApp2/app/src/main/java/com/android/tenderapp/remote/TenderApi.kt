package com.android.tenderapp.remote

import com.android.tenderapp.data.TenderResponse
import retrofit2.http.GET

interface TenderApi {
    @GET("pl/tenders")
    suspend fun getTenders(): TenderResponse
}
