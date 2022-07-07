package com.example.supertajnyprojekt.features.locations.data.repository

import com.example.supertajnyprojekt.core.api.RickAndMortyApi
import com.example.supertajnyprojekt.core.api.model.response.LocationResponse
import com.example.supertajnyprojekt.core.network.NetworkStateProvider
import com.example.supertajnyprojekt.features.locations.data.local.LocationDao
import com.example.supertajnyprojekt.features.locations.data.local.model.LocationCached
import com.example.supertajnyprojekt.features.locations.domain.LocationRepository
import com.example.supertajnyprojekt.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

internal class LocationRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN location request THEN fetch locations from API`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getLocations() } returns LocationResponse.mock()
        }
        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider)

        // when
        runBlocking { repository.getLocations() }

        //then
        coVerify { api.getLocations() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN location request THEN save location to local database`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getLocations() } returns LocationResponse.mock()
        }
        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider)

        // when
        runBlocking { repository.getLocations() }

        //then
        coVerify { locationDao.saveLocations(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN location request THEN fetch locations from local database`() {
        //given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val locationDao = mockk<LocationDao> {
            coEvery { getLocations() } returns listOf(LocationCached.mock(), LocationCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }

        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider)

        // when
        runBlocking { repository.getLocations() }

        //then
        coVerify { locationDao.getLocations() }
    }
}