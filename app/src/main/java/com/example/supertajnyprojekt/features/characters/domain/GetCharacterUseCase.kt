package com.example.supertajnyprojekt.features.characters.domain

import com.example.supertajnyprojekt.core.base.UseCase
import com.example.supertajnyprojekt.features.characters.domain.model.Character
import com.example.supertajnyprojekt.features.characters.presentation.CharacterRepository

class GetCharacterUseCase(private val characterRepository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {

    override suspend fun action(params: Unit): List<Character> {
        return characterRepository.getCharacters()
    }
}