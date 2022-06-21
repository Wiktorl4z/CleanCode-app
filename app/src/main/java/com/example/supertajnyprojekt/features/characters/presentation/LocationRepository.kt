package com.example.supertajnyprojekt.features.characters.presentation

import com.example.supertajnyprojekt.features.characters.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}