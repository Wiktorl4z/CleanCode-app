package com.example.supertajnyprojekt.core.api.model

import com.example.supertajnyprojekt.features.characters.domain.model.Character
import com.example.supertajnyprojekt.features.characters.domain.model.Origin
import com.google.gson.annotations.SerializedName

data class CharacterRemote(
    @SerializedName("created") val created: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("gender") val gender: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("location") val locationRemote: LocationRemote,
    @SerializedName("name") val name: String,
    @SerializedName("origin") val originRemote: OriginRemote,
    @SerializedName("species") val species: String,
    @SerializedName("status") val status: String,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
) {
    fun toCharacter() = Character(
        created = created,
        episode = episode,
        gender = gender,
        id = id,
        image = image,
        location = locationRemote.toLocation(),
        name = name,
        origin = originRemote.toOrigin(),
        species = species,
        status = status,
        type = type,
        url = url
    )
}

data class OriginRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toOrigin() = Origin(
        name = name,
        url = url
    )
}