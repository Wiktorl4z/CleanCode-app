package com.example.supertajnyprojekt.core.api.model.response

import com.example.supertajnyprojekt.core.api.model.remote.LocationRemote
import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("info") val info: InfoResponse,
    @SerializedName("results") val results: List<LocationRemote>
) {
    companion object
}