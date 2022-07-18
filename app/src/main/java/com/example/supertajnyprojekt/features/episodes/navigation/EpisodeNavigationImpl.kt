package com.example.supertajnyprojekt.features.episodes.navigation

import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.navigation.FragmentNavigator
import com.example.supertajnyprojekt.features.episodes.details.presentation.EpisodeDetailsFragment
import com.example.supertajnyprojekt.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeNavigationImpl(
    private val fragmentNavigator: FragmentNavigator
) : EpisodeNavigation {
    override fun openEpisodeDetailsScreen(episode: EpisodeDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_episodes_screen_to_episode_details_screen,
            EpisodeDetailsFragment.EPISODE_DETAILS_KEY to episode
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}