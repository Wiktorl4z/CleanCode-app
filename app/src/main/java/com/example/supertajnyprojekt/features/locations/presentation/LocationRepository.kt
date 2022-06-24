package com.example.supertajnyprojekt.features.locations.presentation

import com.example.supertajnyprojekt.features.locations.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}