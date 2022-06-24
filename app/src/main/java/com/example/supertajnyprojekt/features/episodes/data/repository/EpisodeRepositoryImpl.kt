package com.example.supertajnyprojekt.features.episodes.data.repository

import com.example.supertajnyprojekt.core.api.RickAndMortyApi
import com.example.supertajnyprojekt.features.episodes.domain.EpisodeRepository
import com.example.supertajnyprojekt.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val api: RickAndMortyApi
) : EpisodeRepository {

    override suspend fun getEpisodes(): List<Episode> {
        return api.getEpisodes().results.map { it.toEpisode() }
    }
}