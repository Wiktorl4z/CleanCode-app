package com.example.supertajnyprojekt.core.api.model.remote

import com.example.supertajnyprojekt.features.characters.domain.model.Character
import com.example.supertajnyprojekt.features.characters.domain.model.CharacterLastLocation
import com.example.supertajnyprojekt.features.characters.domain.model.CharacterOriginLocation
import com.google.gson.annotations.SerializedName

data class CharacterRemote(
    @SerializedName("created") val created: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("gender") val gender: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("location") val characterLastLocationRemote: CharacterLastLocationRemote,
    @SerializedName("name") val name: String,
    @SerializedName("origin") val characterOriginRemote: CharacterOriginLocationRemote,
    @SerializedName("species") val species: String,
    @SerializedName("status") val status: String,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
) {

    companion object

    fun toCharacter() = Character(
        created = created,
        episode = episode,
        gender = gender,
        id = id,
        image = image,
        characterLastLocation = characterLastLocationRemote.toLastLocation(),
        name = name,
        characterOriginLocation = characterOriginRemote.toOriginLocation(),
        species = species,
        status = status,
        type = type,
        url = url
    )
}

data class CharacterOriginLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toOriginLocation() = CharacterOriginLocation(
        name = name,
        url = url
    )
}

data class CharacterLastLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toLastLocation() = CharacterLastLocation(
        name = name,
        url = url
    )
}