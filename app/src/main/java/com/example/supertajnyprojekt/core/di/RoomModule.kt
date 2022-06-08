package com.example.supertajnyprojekt.core.di

import androidx.room.Room
import com.example.supertajnyprojekt.features.data.RickAndMortDB
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            RickAndMortDB::class.java, "database-name"
        ).build()
    }
}
