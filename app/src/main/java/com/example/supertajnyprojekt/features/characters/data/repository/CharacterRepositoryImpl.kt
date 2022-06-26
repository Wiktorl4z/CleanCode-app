package com.example.supertajnyprojekt.features.characters.data.repository

import com.example.supertajnyprojekt.core.api.RickAndMortyApi
import com.example.supertajnyprojekt.core.network.NetworkStateProvider
import com.example.supertajnyprojekt.features.characters.data.local.CharacterDao
import com.example.supertajnyprojekt.features.characters.data.local.model.CharacterCached
import com.example.supertajnyprojekt.features.characters.domain.CharacterRepository
import com.example.supertajnyprojekt.features.characters.domain.model.Character

class CharacterRepositoryImpl(
    private val api: RickAndMortyApi,
    private val dao: CharacterDao,
    private val networkStateProvider: NetworkStateProvider
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getCharactersFromRemote().also { saveCharacterToLocal(it) }
        } else {
            getCharactersFromLocal()
        }
    }

    private suspend fun getCharactersFromRemote(): List<Character> {
        return api.getCharacters().results
            .map { it.toCharacter() }
            .also { saveCharacterToLocal(it) }
    }

    private suspend fun saveCharacterToLocal(characters: List<Character>) {
        characters.map { CharacterCached(it) }
            .toTypedArray()
            .let { dao.saveCharacters(*it) }
    }

    private suspend fun getCharactersFromLocal(): List<Character> {
        return dao.getCharacters().map { it.toCharacter() }
    }
}