package com.example.supertajnyprojekt.mock

import com.example.supertajnyprojekt.core.api.model.remote.*
import com.example.supertajnyprojekt.core.api.model.response.CharacterResponse
import com.example.supertajnyprojekt.core.api.model.response.EpisodeResponse
import com.example.supertajnyprojekt.core.api.model.response.InfoResponse
import com.example.supertajnyprojekt.core.api.model.response.LocationResponse
import com.example.supertajnyprojekt.features.characters.data.local.model.CharacterCached
import com.example.supertajnyprojekt.features.characters.data.local.model.CharacterLastLocationCached
import com.example.supertajnyprojekt.features.characters.data.local.model.CharacterOriginLocationCached
import com.example.supertajnyprojekt.features.characters.domain.model.Character
import com.example.supertajnyprojekt.features.characters.domain.model.CharacterLastLocation
import com.example.supertajnyprojekt.features.characters.domain.model.CharacterOriginLocation
import com.example.supertajnyprojekt.features.characters.presentation.model.CharacterDisplayable
import com.example.supertajnyprojekt.features.characters.presentation.model.CharacterLastLocationDisplayable
import com.example.supertajnyprojekt.features.characters.presentation.model.CharacterOriginLocationDisplayable
import com.example.supertajnyprojekt.features.episodes.data.local.model.EpisodeCached
import com.example.supertajnyprojekt.features.episodes.domain.model.Episode
import com.example.supertajnyprojekt.features.episodes.presentation.model.EpisodeDisplayable
import com.example.supertajnyprojekt.features.locations.data.local.model.LocationCached
import com.example.supertajnyprojekt.features.locations.domain.model.Location
import com.example.supertajnyprojekt.features.locations.presentation.model.LocationDisplayable
import org.jetbrains.annotations.TestOnly

@TestOnly
fun InfoResponse.Companion.mock() = InfoResponse(
    count = 10,
    pages = 3,
    next = "next page url",
    prev = "previous page url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url",
    created = "example data"
)

@TestOnly
fun EpisodeResponse.Companion.mock() = EpisodeResponse(
    info = InfoResponse.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    dimension = "dimension",
    id = 1,
    name = "location remote name",
    residents = emptyList(),
    type = "location remote type",
    url = "episode url"
)

@TestOnly
fun LocationResponse.Companion.mock() = LocationResponse(
    info = InfoResponse.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock(),
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 1,
    dimension = "dimension",
    name = "location cached",
    residents = emptyList(),
    type = "type",
    url = "location url"
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    id = 1,
    created = "example date",
    episode = emptyList(),
    gender = "character gender",
    image = "image url",
    characterLastLocationRemote = CharacterLastLocationRemote(
        name = "location name",
        url = "location url"
    ),
    name = "character name",
    characterOriginRemote = CharacterOriginLocationRemote(
        name = "location name",
        url = "location url"
    ),
    species = "character species",
    status = "character status",
    type = "character type",
    url = "character url"
)

@TestOnly
fun CharacterResponse.Companion.mock() = CharacterResponse(
    info = InfoResponse.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock(),
    )
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 1,
    created = "example date",
    episode = emptyList(),
    gender = "character gender",
    image = "image url",
    location = CharacterLastLocationCached(name = "location name", url = "location url"),
    name = "character name",
    origin = CharacterOriginLocationCached(name = "location name", url = "location url"),
    species = "character species",
    status = "character status",
    type = "character type",
    url = "character url"
)

@TestOnly
fun Episode.Companion.mock() = Episode(
    airDate = "airDate",
    characters = listOf(),
    code = "code",
    id = 1,
    name = "name",
    url = "url"
)

@TestOnly
fun Location.Companion.mock() = Location(
    dimension = "dimension",
    id = 1,
    name = "name",
    residents = listOf(),
    type = "type",
    url = "url"
)

@TestOnly
fun Character.Companion.mock() = Character(
    created = "created",
    episode = listOf(),
    gender = "gender",
    id = 1,
    image = "image",
    location = CharacterLastLocation(
        name = "location name",
        url = "location url"
    ),
    name = "character name",
    origin = CharacterOriginLocation(
        name = "location name",
        url = "location url"
    ),
    species = "species",
    status = "status",
    type = "type",
    url = "url"
)

@TestOnly
fun EpisodeDisplayable.Companion.mock() = EpisodeDisplayable(
    airDate = "airDate",
    characters = listOf(),
    code = "code",
    id = 1,
    name = "name",
    url = "url"
)

@TestOnly
fun CharacterDisplayable.Companion.mock() = CharacterDisplayable(
    created = "created",
    episode = listOf(),
    gender = "gender",
    id = 1,
    image = "image",
    location = CharacterLastLocationDisplayable(
        name = "location name",
        url = "location url"
    ),
    name = "name",
    originDisplayable = CharacterOriginLocationDisplayable(
        name = "location name",
        url = "location url"
    ),
    species = "species",
    status = "status",
    type = "type",
    url = "url"
)

@TestOnly
fun LocationDisplayable.Companion.mock() = LocationDisplayable(
    dimension = "dimension",
    id = 1,
    name = "location remote name",
    residents = emptyList(),
    type = "location remote type",
    url = "episode url"
)

