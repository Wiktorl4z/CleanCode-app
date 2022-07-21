package com.example.supertajnyprojekt.features.characters.presentation.model

import android.os.Parcelable
import com.example.supertajnyprojekt.features.characters.domain.model.Character
import com.example.supertajnyprojekt.features.characters.domain.model.CharacterLastLocation
import com.example.supertajnyprojekt.features.characters.domain.model.CharacterOriginLocation
import kotlinx.parcelize.Parcelize


@Parcelize
data class CharacterDisplayable(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterLastLocationDisplayable,
    val name: String,
    val originDisplayable: CharacterOriginLocationDisplayable,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) : Parcelable {
    constructor(character: Character) : this(
        created = character.created,
        episode = character.episode,
        gender = character.gender,
        id = character.id,
        image = character.image,
        location = CharacterLastLocationDisplayable(character.location),
        name = character.name,
        originDisplayable = CharacterOriginLocationDisplayable(character.origin),
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )

    companion object
}

@Parcelize
data class CharacterOriginLocationDisplayable(
    val name: String,
    val url: String
) : Parcelable {
    constructor(origin: CharacterOriginLocation) : this(
        name = origin.name,
        url = origin.url
    )
}

@Parcelize
data class CharacterLastLocationDisplayable(
    val name: String,
    val url: String
) : Parcelable {
    constructor(location: CharacterLastLocation) : this(
        name = location.name,
        url = location.url
    )
}