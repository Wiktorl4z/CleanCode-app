package com.example.supertajnyprojekt.features.locations.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.supertajnyprojekt.core.base.BaseViewModel
import com.example.supertajnyprojekt.core.exception.ErrorMapper
import com.example.supertajnyprojekt.features.locations.domain.GetLocationUseCase
import com.example.supertajnyprojekt.features.locations.domain.model.Location
import com.example.supertajnyprojekt.features.locations.presentation.model.LocationDisplayable

class LocationViewModel(
    private val getLocationUseCase: GetLocationUseCase,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _locations by lazy {
        MutableLiveData<List<Location>>()
            .also { getLocations(it) }
    }

    val locations: LiveData<List<LocationDisplayable>> by lazy {
        _locations.map { locations ->
            locations.map { LocationDisplayable(it) }
        }
    }

    private fun getLocations(locationLiveData: MutableLiveData<List<Location>>) {
        setPendingState()
        getLocationUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { locationLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }
}