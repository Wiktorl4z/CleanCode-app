package com.example.supertajnyprojekt.features.characters.domain

import com.example.supertajnyprojekt.core.base.UseCase
import com.example.supertajnyprojekt.features.characters.domain.model.Location
import com.example.supertajnyprojekt.features.characters.presentation.LocationRepository

class GetLocationUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, Unit>() {

    override suspend fun action(params: Unit): List<Location> {
        return locationRepository.getLocations()
    }
}