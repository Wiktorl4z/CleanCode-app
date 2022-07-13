package com.example.supertajnyprojekt.features.characters.domain

import com.example.supertajnyprojekt.features.locations.domain.GetLocationUseCase
import com.example.supertajnyprojekt.features.locations.domain.LocationRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetLocationUseCaseTest {

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun `when use case is invoked than execute getCharacters method from repository`() {
        // given
        val repository = mockk<LocationRepository>(relaxed = true)
        val useCase = GetLocationUseCase(repository)

        //when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        //then
        coVerify { repository.getLocations() }
    }
}