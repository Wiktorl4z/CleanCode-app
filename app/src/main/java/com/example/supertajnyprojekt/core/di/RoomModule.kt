package com.example.supertajnyprojekt.core.di

import androidx.room.Room
import com.example.supertajnyprojekt.core.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, "database-name"
        ).build()
    }

    single { get<AppDatabase>().episodeDao() }
    single { get<AppDatabase>().locationDao() }
    single { get<AppDatabase>().characterDao() }
}
