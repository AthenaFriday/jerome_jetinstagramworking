package com.android.offlinecaching.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.offlinecaching.data.Cars
import com.android.offlinecaching.data.CarsRepository
import com.android.offlinecaching.data.getDatabase
import com.android.offlinecaching.network.CarsApi
import kotlinx.coroutines.launch

class CarsViewModel(application: Application, private val token: String?) :
    AndroidViewModel(application) {

    private val repository = CarsRepository(
        getDatabase(application),
        CarsApi.retrofitService
    )

    val carsList: LiveData<List<Cars>> = repository.getCars()

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>(null)
    val errorMessage: LiveData<String?> = _errorMessage

    init {
        fetchCars()
    }

    private fun fetchCars() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                repository.refreshCars(token)
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load cars: ${e.localizedMessage ?: "Unknown error"}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
