package com.example.supertajnyprojekt.features.characters.domain.model

data class Character(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val characterLastLocation: CharacterLastLocation,
    val name: String,
    val characterOriginLocation: CharacterOriginLocation,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    companion object
}

data class CharacterOriginLocation(
    val name: String,
    val url: String
) {
    companion object
}

data class CharacterLastLocation(
    val name: String,
    val url: String
) {
    companion object
}