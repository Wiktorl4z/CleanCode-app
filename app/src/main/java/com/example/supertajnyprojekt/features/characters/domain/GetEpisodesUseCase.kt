package com.example.supertajnyprojekt.features.characters.domain

import com.example.supertajnyprojekt.core.base.UseCase
import com.example.supertajnyprojekt.features.characters.domain.model.Episode
import com.example.supertajnyprojekt.features.characters.presentation.EpisodeRepository

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {

    override suspend fun action(params: Unit): List<Episode> {
        return episodeRepository.getEpisodes()
    }
}