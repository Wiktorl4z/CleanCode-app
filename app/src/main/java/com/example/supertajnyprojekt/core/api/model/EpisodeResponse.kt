package com.example.supertajnyprojekt.core.api.model

import com.google.gson.annotations.SerializedName

class EpisodeResponse(
    @SerializedName("info") val info: InfoResponse,
    @SerializedName("results") val results: List<EpisodeRemote>,
) {
    companion object
}