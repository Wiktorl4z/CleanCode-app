package com.example.supertajnyprojekt.features.episodes.domain.model

data class Episode(
    val airDate: String,
    val characters: List<String>,
    val code: String,
    val id: Int,
    val name: String,
    val url: String
) {
    companion object
}