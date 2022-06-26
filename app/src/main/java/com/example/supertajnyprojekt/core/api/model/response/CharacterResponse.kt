package com.example.supertajnyprojekt.core.api.model.response

import com.example.supertajnyprojekt.core.api.model.remote.CharacterRemote
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info") val info: InfoResponse,
    @SerializedName("results") val results: List<CharacterRemote>
) {
    companion object
}