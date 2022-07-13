package com.example.supertajnyprojekt.core.di

import org.koin.core.module.Module

val koinInjector: List<Module> = featureModule
    .plus(networkModule)
    .plus(roomModule)
    .plus(appModule)
