package com.example.supertajnyprojekt.features.characters.domain

import com.example.supertajnyprojekt.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}