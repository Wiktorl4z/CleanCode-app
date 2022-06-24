package com.example.supertajnyprojekt.core.api

import com.example.supertajnyprojekt.core.api.model.EpisodeResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episodes")
    suspend fun getEpisodes(): EpisodeResponse
}