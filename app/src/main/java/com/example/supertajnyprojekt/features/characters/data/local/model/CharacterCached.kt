package com.example.supertajnyprojekt.features.characters.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.supertajnyprojekt.features.characters.domain.model.Character
import com.example.supertajnyprojekt.features.characters.domain.model.CharacterLastLocation
import com.example.supertajnyprojekt.features.characters.domain.model.CharacterOriginLocation

@Entity
class CharacterCached(
    @PrimaryKey
    val id: Int,
    val created: String,
    val episode: List<String>,
    val gender: String,
    val image: String,
    val location: CharacterLastLocationCached,
    val name: String,
    val origin: CharacterOriginLocationCached,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    constructor(character: Character) : this(
        id = character.id,
        created = character.created,
        episode = character.episode,
        gender = character.gender,
        image = character.image,
        location = CharacterLastLocationCached(character.location),
        name = character.name,
        origin = CharacterOriginLocationCached(character.origin),
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url,
    )

    companion object

    fun toCharacter() = Character(
        created,
        episode,
        gender,
        id,
        image,
        location.toLastLocation(),
        name,
        origin.toOriginLocation(),
        species,
        status,
        type,
        url
    )
}

data class CharacterOriginLocationCached(
    val name: String,
    val url: String
) {
    constructor(location: CharacterOriginLocation) : this(
        name = location.name,
        url = location.url
    )

    fun toOriginLocation() = CharacterOriginLocation(
        name = name,
        url = url
    )
}

data class CharacterLastLocationCached(
    val name: String,
    val url: String
) {
    constructor(location: CharacterLastLocation) : this(
        name = location.name,
        url = location.url
    )

    fun toLastLocation() = CharacterLastLocation(
        name = name,
        url = url
    )
}