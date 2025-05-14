package com.android.tenderapp.tender

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.tenderapp.repository.TenderRepository
import com.android.tenderapp.ui.TenderUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TenderViewModel @Inject constructor(
    private val repository: TenderRepository
) : ViewModel() {

    private val _state = MutableStateFlow<TenderUiState>(TenderUiState.Loading)
    val state: StateFlow<TenderUiState> = _state.asStateFlow()

    init {
        getTenders()
    }

    private fun getTenders() {
        viewModelScope.launch {
            _state.value = TenderUiState.Loading
            try {
                val tenders = repository.fetchTenders()
                _state.value = TenderUiState.Success(tenders)
            } catch (e: Exception) {
                _state.value = TenderUiState.Error(e.localizedMessage ?: "Error")
            }
        }
    }
}
