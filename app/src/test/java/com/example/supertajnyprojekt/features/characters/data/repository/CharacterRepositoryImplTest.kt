package com.example.supertajnyprojekt.features.characters.data.repository

import com.example.supertajnyprojekt.core.api.RickAndMortyApi
import com.example.supertajnyprojekt.core.api.model.response.CharacterResponse
import com.example.supertajnyprojekt.core.exception.ErrorWrapper
import com.example.supertajnyprojekt.core.network.NetworkStateProvider
import com.example.supertajnyprojekt.features.characters.data.local.CharacterDao
import com.example.supertajnyprojekt.features.characters.data.local.model.CharacterCached
import com.example.supertajnyprojekt.features.characters.domain.CharacterRepository
import com.example.supertajnyprojekt.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

internal class CharacterRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN character request THEN fetch characters from API`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getCharacters() } returns CharacterResponse.mock()
        }
        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)
        val repository: CharacterRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { api.getCharacters() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN characters request THEN save characters to local database`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getCharacters() } returns CharacterResponse.mock()
        }
        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)
        val repository: CharacterRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { characterDao.saveCharacters(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN characters request THEN fetch characters from local database`() {
        //given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val characterDao = mockk<CharacterDao> {
            coEvery { getCharacters() } returns listOf(
                CharacterCached.mock(),
                CharacterCached.mock()
            )
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }

        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)
        val repository: CharacterRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { characterDao.getCharacters() }
    }
}