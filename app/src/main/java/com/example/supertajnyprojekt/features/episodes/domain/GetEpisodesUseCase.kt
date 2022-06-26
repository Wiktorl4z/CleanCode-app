package com.example.supertajnyprojekt.features.episodes.domain

import com.example.supertajnyprojekt.core.base.UseCase
import com.example.supertajnyprojekt.features.episodes.domain.model.Episode

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {

    override suspend fun action(params: Unit): List<Episode> {
        return episodeRepository.getCharacters()
    }
}