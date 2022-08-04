package com.example.supertajnyprojekt.features.episodes.presentation.model

import android.os.Parcelable
import com.example.supertajnyprojekt.features.episodes.domain.model.Episode
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize


@Parcelize
data class EpisodeDisplayable(
    val airDate: String,
    val characters: List<String>,
    val code: String,
    val id: Int,
    val name: String,
    val url: String
) : Parcelable {

    constructor(episode: Episode) : this(
        id = episode.id,
        name = episode.name,
        airDate = episode.airDate,
        code = episode.code,
        characters = episode.characters,
        url = episode.url
    )

    @IgnoredOnParcel
    val fullName = "$code: $name"

    companion object
}