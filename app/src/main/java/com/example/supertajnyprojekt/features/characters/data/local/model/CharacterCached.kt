package com.example.supertajnyprojekt.features.characters.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.supertajnyprojekt.features.characters.domain.model.Character
import com.example.supertajnyprojekt.features.characters.domain.model.CharacterLastLocation
import com.example.supertajnyprojekt.features.characters.domain.model.CharacterOriginLocation

@Entity(tableName = "character")
data class CharacterCached(
    @PrimaryKey
    val id: Int,
    val created: String,
    val episode: List<String>,
    val gender: String,
    val image: String,
    @Embedded
    val location: CharacterLastLocationCached,
    val name: String,
    @Embedded
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
        location = CharacterLastLocationCached(character.characterLastLocation),
        name = character.name,
        origin = CharacterOriginLocationCached(character.characterOriginLocation),
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
@Entity
data class CharacterOriginLocationCached(
    val characterOriginLocationCachedName: String,
    val characterOriginLocationUrl: String
) {
    constructor(location: CharacterOriginLocation) : this(
        characterOriginLocationCachedName = location.name,
        characterOriginLocationUrl = location.url
    )

    fun toOriginLocation() = CharacterOriginLocation(
        name = characterOriginLocationCachedName,
        url = characterOriginLocationUrl
    )
}
@Entity
data class CharacterLastLocationCached(
    val characterLastLocationCachedName: String,
    val characterLastLocationCachedUrl: String
) {
    constructor(location: CharacterLastLocation) : this(
        characterLastLocationCachedName = location.name,
        characterLastLocationCachedUrl = location.url
    )

    fun toLastLocation() = CharacterLastLocation(
        name = characterLastLocationCachedName,
        url = characterLastLocationCachedUrl
    )
}