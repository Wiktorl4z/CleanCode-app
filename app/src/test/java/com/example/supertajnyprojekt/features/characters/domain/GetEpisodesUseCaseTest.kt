package com.example.supertajnyprojekt.features.characters.domain

import com.example.supertajnyprojekt.features.episodes.domain.EpisodeRepository
import com.example.supertajnyprojekt.features.episodes.domain.GetEpisodesUseCase
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetEpisodesUseCaseTest {

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun `when use case is invoked than execute getEpisodes method from repository`() {
        // given
        val repository = mockk<EpisodeRepository>(relaxed = true)
        val useCase = GetEpisodesUseCase(repository)

        //when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        //then
        coVerify { repository.getCharacters() }
    }
}