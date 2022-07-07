package com.example.supertajnyprojekt.core.network

interface NetworkStateProvider {
    fun isNetworkAvailable(): Boolean
}