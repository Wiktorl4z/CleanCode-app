package com.example.supertajnyprojekt.features.locations.domain

import com.example.supertajnyprojekt.features.locations.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}