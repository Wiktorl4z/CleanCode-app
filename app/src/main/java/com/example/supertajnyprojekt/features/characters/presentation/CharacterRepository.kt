package com.example.supertajnyprojekt.features.characters.presentation

import com.example.supertajnyprojekt.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}