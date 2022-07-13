package com.example.supertajnyprojekt.features.characters.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetCharacterUseCaseTest {

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun `when use case is invoked than execute getCharacters method from repository`() {
        // given
        val repository = mockk<CharacterRepository>(relaxed = true)
        val useCase = GetCharacterUseCase(repository)

        //when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        //then
        coVerify { repository.getCharacters() }
    }
}