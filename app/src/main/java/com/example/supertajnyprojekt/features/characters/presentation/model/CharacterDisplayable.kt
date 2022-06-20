package com.example.supertajnyprojekt.features.characters.presentation.model

import com.example.supertajnyprojekt.features.characters.domain.model.Character
import com.example.supertajnyprojekt.features.characters.domain.model.Origin

class CharacterDisplayable(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDisplayable,
    val name: String,
    val originDisplayable: OriginDisplayable,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    constructor(character: Character) : this(
        created = character.created,
        episode = character.episode,
        gender = character.gender,
        id = character.id,
        image = character.image,
        location = LocationDisplayable(character.location),
        name = character.name,
        originDisplayable = OriginDisplayable(character.origin),
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )
}

data class OriginDisplayable(
    val name: String,
    val url: String
) {
    constructor(origin: Origin) : this(
        name = origin.name,
        url = origin.url
    )
}