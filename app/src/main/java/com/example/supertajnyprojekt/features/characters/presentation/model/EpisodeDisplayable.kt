package com.example.supertajnyprojekt.features.characters.presentation.model

import com.example.supertajnyprojekt.features.characters.domain.model.Episode

data class EpisodeDisplayable(
    val airDate: String,
    val characters: List<String>,
    val code: String,
    val id: Int,
    val name: String,
    val url: String
) {
    constructor(episode: Episode) : this(
        id = episode.id,
        name = episode.name,
        airDate = episode.airDate,
        code = episode.code,
        characters = episode.characters,
        url = episode.url
    )
}