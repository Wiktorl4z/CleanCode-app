package com.example.supertajnyprojekt.core.di

import com.example.supertajnyprojekt.features.episodes.di.episodeModule
import org.koin.core.module.Module

val featureModule = listOf<Module>(
    episodeModule
)