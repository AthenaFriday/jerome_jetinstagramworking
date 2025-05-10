package com.android.offlinecaching.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CarsViewModelFactory(
    private val app: Application,
    private val token: String?
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CarsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CarsViewModel(app, token) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
