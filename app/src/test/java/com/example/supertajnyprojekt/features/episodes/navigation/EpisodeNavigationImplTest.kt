package com.example.supertajnyprojekt.features.episodes.navigation

import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.navigation.FragmentNavigator
import com.example.supertajnyprojekt.features.episodes.presentation.model.EpisodeDisplayable
import com.example.supertajnyprojekt.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class EpisodeNavigationImplTest {

    @Test
    fun `WHEN openEpisodeDetailsScreen is called THAN invoke navigateTo method with appropriate action and episode model as arguments`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val episodeNavigator: EpisodeNavigator = EpisodeNavigatorImpl(fragmentNavigator)
        val episode = EpisodeDisplayable.mock()
        val slot = slot<Pair<String, EpisodeDisplayable>>()

        //when
        episodeNavigator.openEpisodeDetailsScreen(episode)

        //then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_episodes_screen_to_episode_details_screen,
                capture(slot)
            )
        }
        slot.captured.second shouldBe episode
    }

    @Test
    fun `WHEN openEpisodeDetailsScreen is called THAN invoke goBack method of FragmentNavigator`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val episodeNavigator: EpisodeNavigator = EpisodeNavigatorImpl(fragmentNavigator)

        //when
        episodeNavigator.goBack()

        //then
        verify {
            fragmentNavigator.goBack()
        }
    }
}