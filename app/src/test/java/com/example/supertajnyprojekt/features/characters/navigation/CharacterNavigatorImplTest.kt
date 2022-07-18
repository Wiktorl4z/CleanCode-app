package com.example.supertajnyprojekt.features.characters.navigation

import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.navigation.FragmentNavigator
import com.example.supertajnyprojekt.features.characters.presentation.model.CharacterDisplayable
import com.example.supertajnyprojekt.features.episodes.navigation.EpisodeNavigator
import com.example.supertajnyprojekt.features.episodes.navigation.EpisodeNavigatorImpl
import com.example.supertajnyprojekt.features.episodes.presentation.model.EpisodeDisplayable
import com.example.supertajnyprojekt.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class CharacterNavigatorImplTest {

    @Test
    fun `WHEN openCharacterDetailsScreen is called THAN invoke navigateTo method with appropriate action and character model as arguments`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator: CharacterNavigator = CharacterNavigatorImpl(fragmentNavigator)
        val character = CharacterDisplayable.mock()
        val slot = slot<Pair<String, CharacterDisplayable>>()

        //when
        characterNavigator.openCharacterDetailsScreen(character)

        //then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_character_screen_to_character_details_screen,
                capture(slot)
            )
        }
        slot.captured.second shouldBe character
    }

    @Test
    fun `WHEN openCharacterDetailsScreen is called THAN invoke goBack method of FragmentNavigator`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator: CharacterNavigator = CharacterNavigatorImpl(fragmentNavigator)

        //when
        characterNavigator.goBack()

        //then
        verify {
            fragmentNavigator.goBack()
        }
    }

}