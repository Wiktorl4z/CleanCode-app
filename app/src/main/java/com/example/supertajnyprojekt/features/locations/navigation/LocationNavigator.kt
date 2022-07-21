package com.example.supertajnyprojekt.features.locations.navigation

import com.example.supertajnyprojekt.features.locations.presentation.model.LocationDisplayable

interface LocationNavigator {
    fun openLocationDetailsScreen(locationDisplayable: LocationDisplayable)
    fun goBack()
}