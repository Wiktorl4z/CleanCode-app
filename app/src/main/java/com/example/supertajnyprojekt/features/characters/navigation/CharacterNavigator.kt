package com.example.supertajnyprojekt.features.characters.navigation

import com.example.supertajnyprojekt.features.characters.presentation.model.CharacterDisplayable

interface CharacterNavigator {
    fun openCharacterDetailsScreen(characterDisplayable: CharacterDisplayable)
    fun goBack()
}