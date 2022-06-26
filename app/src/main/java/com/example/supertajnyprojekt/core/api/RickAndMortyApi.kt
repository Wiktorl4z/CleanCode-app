package com.example.supertajnyprojekt.core.api

import com.example.supertajnyprojekt.core.api.model.response.CharacterResponse
import com.example.supertajnyprojekt.core.api.model.response.EpisodeResponse
import com.example.supertajnyprojekt.core.api.model.response.LocationResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EpisodeResponse

    @GET("character")
    suspend fun getCharacters(): CharacterResponse

    @GET("location")
    suspend fun getLocations(): LocationResponse

}