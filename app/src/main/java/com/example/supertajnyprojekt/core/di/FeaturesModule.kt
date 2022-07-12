package com.example.supertajnyprojekt.core.di

import com.example.supertajnyprojekt.features.characters.di.characterModule
import com.example.supertajnyprojekt.features.episodes.di.episodeModule
import com.example.supertajnyprojekt.features.locations.di.locationModule
import org.koin.core.module.Module

val featureModule = listOf<Module>(
    episodeModule,
    characterModule,
    locationModule
)