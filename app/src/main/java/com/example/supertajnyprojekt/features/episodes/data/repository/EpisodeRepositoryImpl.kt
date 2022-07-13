package com.example.supertajnyprojekt.features.episodes.data.repository

import com.example.supertajnyprojekt.core.api.RickAndMortyApi
import com.example.supertajnyprojekt.core.exception.ErrorWrapper
import com.example.supertajnyprojekt.core.exception.callOrThrow
import com.example.supertajnyprojekt.core.network.NetworkStateProvider
import com.example.supertajnyprojekt.features.episodes.data.local.EpisodeDao
import com.example.supertajnyprojekt.features.episodes.data.local.model.EpisodeCached
import com.example.supertajnyprojekt.features.episodes.domain.EpisodeRepository
import com.example.supertajnyprojekt.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val api: RickAndMortyApi,
    private val dao: EpisodeDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : EpisodeRepository {

    override suspend fun getEpisodes(): List<Episode> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) { getEpisodesFromRemote() }.also { saveEpisodesToLocal(it) }
        } else {
            getEpisodesFromLocal()
        }
    }

    private suspend fun getEpisodesFromRemote(): List<Episode> {
        return api.getEpisodes().results
            .map { it.toEpisode() }
            .also { saveEpisodesToLocal(it) }
    }

    private suspend fun saveEpisodesToLocal(episodes: List<Episode>) {
        episodes.map { EpisodeCached(it) }
            .toTypedArray()
            .let { dao.saveEpisodes(*it) }
    }

    private suspend fun getEpisodesFromLocal(): List<Episode> {
        return dao.getEpisodes().map { it.toEpisode() }
    }
}