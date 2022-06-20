package com.example.supertajnyprojekt.core.di

import org.koin.core.module.Module

val koinInjector: List<Module> = listOf(
    networkModule,
    roomModule,
    appModule
)