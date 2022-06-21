package com.example.supertajnyprojekt.features.characters.presentation

import com.example.supertajnyprojekt.features.characters.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}