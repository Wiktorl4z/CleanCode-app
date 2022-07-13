package com.example.supertajnyprojekt.features.episodes.navigation

import com.example.supertajnyprojekt.features.episodes.presentation.model.EpisodeDisplayable

interface EpisodeNavigation {
    fun openEpisodeDetailsScreen(episode: EpisodeDisplayable)
    fun goBack()
}