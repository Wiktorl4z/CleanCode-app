package com.example.supertajnyprojekt.features.locations.domain

import com.example.supertajnyprojekt.core.base.UseCase
import com.example.supertajnyprojekt.features.locations.domain.model.Location

class GetLocationUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, Unit>() {

    override suspend fun action(params: Unit): List<Location> {
        return locationRepository.getLocations()
    }
}