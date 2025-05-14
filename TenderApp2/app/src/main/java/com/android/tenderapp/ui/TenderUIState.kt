package com.android.tenderapp.ui

import com.android.tenderapp.data.Tender

sealed class TenderUiState {
    object Loading : TenderUiState()
    data class Success(val tenders: List<Tender>) : TenderUiState()
    data class Error(val message: String) : TenderUiState()
}
