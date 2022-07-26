package com.example.supertajnyprojekt.features.locations.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.supertajnyprojekt.core.base.BaseViewModel
import com.example.supertajnyprojekt.features.locations.presentation.model.LocationDisplayable

class LocationDetailsViewModel : BaseViewModel() {

    private val _location by lazy { MutableLiveData<LocationDisplayable>() }
    val location: LiveData<LocationDisplayable> by lazy { _location }

    fun passLocation(location: LocationDisplayable) {
        _location.value = location
    }
}