package com.example.supertajnyprojekt.features.characters.navigation

import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.navigation.FragmentNavigator
import com.example.supertajnyprojekt.features.characters.details.presentation.CharacterDetailsFragment
import com.example.supertajnyprojekt.features.characters.presentation.model.CharacterDisplayable
import com.example.supertajnyprojekt.features.episodes.details.presentation.EpisodeDetailsFragment

class CharacterNavigatorImpl(
    private val fragmentNavigator: FragmentNavigator
) : CharacterNavigator {
    override fun openCharacterDetailsScreen(characterDisplayable: CharacterDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_character_screen_to_character_details_screen,
            CharacterDetailsFragment.CHARACTER_DETAILS_KEY to characterDisplayable
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}